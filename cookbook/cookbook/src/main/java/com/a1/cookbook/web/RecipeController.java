package com.a1.cookbook.web;

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

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String getRecipes(Model model) {
        List<CompleteRecipe> recipes = this.recipeService.getAllRecipes();
        model.addAttribute("title", "the Recipinomicon!");
        model.addAttribute("recipes", recipes);
        return "recipeList";
    }
    @RequestMapping(
            value = {"/add","add"},
            params = {"name", "category", "ingredients", "instructions", "creatorId"},
            method = RequestMethod.POST
    )
    public String addRecipe(
            @RequestParam(value = "name")String name,
            @RequestParam(value = "category")String category,
            @RequestParam(value = "ingredients")String ingredients,
            @RequestParam(value = "instructions")String instructions,
            @RequestParam(value = "creatorId")int creatorId) {
        Long creatorIdLong = (long) creatorId;
        this.recipeService.addRecipe(name, category, ingredients, instructions, creatorIdLong);
        return "recipeList";
    }
    @RequestMapping(
            value = {"/delete","delete"},
            method = RequestMethod.POST)
    @ResponseBody
    public String deleteRecipe(@RequestParam(value = "id") Long recipeId) {
        this.recipeService.deleteRecipe(recipeId);
        return "recipeList";
    }
}
