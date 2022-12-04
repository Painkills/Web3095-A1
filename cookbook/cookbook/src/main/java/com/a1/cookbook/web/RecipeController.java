//* Project: < cookbook.a1.com >
//		* Assignment: Comp 3095 #1
//		* Author(s): David Fortich, Mitesh Mitry, Ronal Rodriguez, Lemuel Javier
//		* Student Number: 101314570, 101248745, 101314540, 101168735
//		* Date: October 14, 2022
//		* Description: The controller maps the requests related to favorite recipes and passes them to the service.

package com.a1.cookbook.web;

import com.a1.cookbook.data.Recipe;
import com.a1.cookbook.service.ChefService;
import com.a1.cookbook.service.CompleteRecipe;
import com.a1.cookbook.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    public final RecipeService recipeService;
    public final ChefService chefService;
    static Long theChefID = 0L;

    public RecipeController(RecipeService recipeService, ChefService chefService) {
        this.recipeService = recipeService;
        this.chefService = chefService;
    }

    @GetMapping(value = {"", "/"})
    private String getAllRecipes(Model model, @RequestParam(value = "chef")Long chef) {
        List<CompleteRecipe> recipes = recipeService.getAllRecipes();
        theChefID = chef;
        model.addAttribute("req", "recipe");
        model.addAttribute("title", "the Recipinomicon!");
        model.addAttribute("recipes", recipes);
        model.addAttribute("ChefId", theChefID);
        return "recipeList";
    }

    @GetMapping("/{recipeId}")
    private String getARecipe(@PathVariable("recipeId") int recipeId, Model model) {
        CompleteRecipe recipe = recipeService.getCompleteRecipeById((long)recipeId);
        model.addAttribute("req", "view");
        model.addAttribute("title", recipe.getRecipeName() + "!");
        model.addAttribute("recipe", recipe);
        return "singleRecipe";
    }


    @GetMapping (value = {"/create"})
    private String addRecipePage(Model model, @RequestParam(value = "chef")Long chef) {
        theChefID = chef;
        model.addAttribute("req", "create");
        model.addAttribute("ChefId", theChefID);

        return "createRecipe";
    }

    @GetMapping (value = {"/update/{recipeId}"})
    private String updateRecipePage(@PathVariable("recipeId") int recipeId, Model model) {
        Recipe recipe = recipeService.getRecipeById((long)recipeId);
        model.addAttribute("req", "edit");
        model.addAttribute("title", "your chance to edit " + recipe.getName() + "!");
        model.addAttribute("recipe", recipe);
        return "redirect:/recipe";
    }

    @PostMapping(value = {"/create", "/update"})
    private String addRecipe(@RequestParam String name, String category, String ingredientString, String instructions, Long id) {
        // turn single string to a List of Strings for ingredients
        List<String> ingredients = Arrays.asList(ingredientString.split(","));
        recipeService.save(name, category, ingredients, instructions, id);
        return "redirect:/recipe";
    }

    @PostMapping("/delete")
    private String deleteRecipe(@RequestParam("id") String recipeAndChefIds) {
        System.out.println("RecipeController received: " + recipeAndChefIds + " as its delete ID parameter");
        String[] values = recipeAndChefIds.split(";");
        Long recipeId = Long.parseLong(values[0]);
        this.recipeService.deleteRecipe(recipeId);
        return "redirect:/recipe";
    }
}
