package com.a1.cookbook.web;

import com.a1.cookbook.service.RecipeService;
import com.a1.cookbook.service.CompleteRecipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/fav")
public class FavoriteController {
    public final RecipeService recipeService;

    public FavoriteController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getFavorites(@RequestParam(value = "chef")int chef, Model model) {
        Long chefId = (long) chef;
        List<CompleteRecipe> recipes = this.recipeService.getFavoriteRecipesByChef(chefId);
        model.addAttribute("req", "favs");
        model.addAttribute("title", "your Favorite Recipes!");
        model.addAttribute("recipes", recipes);
        return "recipeList";
    }

    @PostMapping("/delete")
    private String deleteFav(@RequestParam("id") int recipeId) {
        this.recipeService.deleteRecipe((long)recipeId);
        return "redirect:/recipe";
    }
}
