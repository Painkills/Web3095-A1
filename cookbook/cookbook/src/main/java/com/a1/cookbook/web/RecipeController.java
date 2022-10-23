package com.a1.cookbook.web;

import com.a1.cookbook.data.Recipe;
import com.a1.cookbook.service.CompleteRecipe;
import com.a1.cookbook.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    public final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = {"", "/"})
    private String getAllRecipes(Model model) {
        List<CompleteRecipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("request", "viewAll");
        model.addAttribute("title", "the Recipinomicon!");
        model.addAttribute("recipes", recipes);
        return "recipeList";
    }

    @GetMapping("/{recipeId}")
    private String getARecipe(@PathVariable("recipeId") int recipeId, Model model) {
        CompleteRecipe recipe = recipeService.getCompleteRecipeById((long)recipeId);
        model.addAttribute("request", "view");
        model.addAttribute("title", recipe.getRecipeName() + "!");
        model.addAttribute("recipe", recipe);
        return "singleRecipe";
    }


    @GetMapping (value = {"/create"})
    private String addRecipePage(Model model) {
        model.addAttribute("request", "create");
        return "createRecipe";
    }

    @GetMapping (value = {"/update/{recipeId}"})
    private String updateRecipePage(@PathVariable("recipeId") int recipeId, Model model) {
        Recipe recipe = recipeService.getRecipeById((long)recipeId);
        model.addAttribute("request", "edit");
        model.addAttribute("title", "your chance to edit " + recipe.getName() + "!");
        model.addAttribute("recipe", recipe);
        return "createRecipe";
    }

    @PostMapping(value = {"/create", "/update"})
    private String addRecipe(@RequestParam String name, String category, String ingredients, String instructions, Long id) {
        recipeService.saveOrUpdate(name, category, ingredients, instructions, id);
        return "recipeList";
    }

    @PostMapping("/delete")
    private String deleteRecipe(@RequestParam("id") int recipeId) {
        this.recipeService.deleteRecipe((long)recipeId);
        return "recipeList";
    }
}
