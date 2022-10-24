package com.a1.cookbook.web;

import com.a1.cookbook.service.FavService;
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
    public final FavService favService;

    public FavoriteController(FavService favService) {
        this.favService = favService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getFavorites(@RequestParam(value = "chef")int chef, Model model) {
        Long chefId = (long) chef;
        List<CompleteRecipe> recipes = this.favService.getFavoriteRecipesByChef(chefId);
        model.addAttribute("chefId", chefId);
        model.addAttribute("req", "favs");
        model.addAttribute("title", "your Favorite Recipes!");
        model.addAttribute("recipes", recipes);
        return "recipeList";
    }

    @PostMapping("/delete")
    private String deleteFav(@RequestParam("id") String recipeAndChefIds) {
        String[] values = recipeAndChefIds.split(";");
        Long recipeId = Long.parseLong(values[0]);
        Long chefId = Long.parseLong(values[0]);
        this.favService.deleteFav(chefId, recipeId);
        return "/";
    }
}
