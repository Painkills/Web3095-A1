package com.a1.cookbook.web;

import com.a1.cookbook.service.CompleteRecipe;
import com.a1.cookbook.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    public final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getRecipes(Model model) {
        List<CompleteRecipe> recipes = this.recipeService.getAllRecipes();
        model.addAttribute("title", "the Recipinomicon!");
        model.addAttribute("recipes", recipes);
        return "recipeList";
    }
}
