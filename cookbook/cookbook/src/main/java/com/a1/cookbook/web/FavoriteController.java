//* Project: < cookbook.a1.com >
//		* Assignment: Comp 3095 #1
//		* Author(s): David Fortich, Mitesh Mitry, Ronal Rodriguez, Lemuel Javier
//		* Student Number: 101314570, 101248745, 101314540, 101168735
//		* Date: October 14, 2022
//		* Description: The controller maps the requests related to favorite recipes and passes them to the service.

package com.a1.cookbook.web;

import com.a1.cookbook.service.FavService;
import com.a1.cookbook.service.CompleteRecipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fav")
public class FavoriteController {
    public final FavService favService;

    public FavoriteController(FavService favService) {
        this.favService = favService;
    }

    @GetMapping(value={"/", ""})
    public String getFavorites(@RequestParam(value = "chef")int chef, Model model) {
        Long chefId = (long) chef;
        List<CompleteRecipe> recipes = this.favService.getFavoriteRecipesByChef(chefId);
        model.addAttribute("chefId", chefId);
        model.addAttribute("req", "fav");
        model.addAttribute("title", "your Favorite Recipes!");
        model.addAttribute("recipes", recipes);
        return "recipeList";
    }

    @PostMapping("/delete")
    private String deleteFav(@RequestParam("id") String recipeAndChefIds) {
        String[] values = recipeAndChefIds.split(";");
        Long recipeId = Long.parseLong(values[0]);
        Long chefId = Long.parseLong(values[1]);
        this.favService.deleteFav(chefId, recipeId);
        return "redirect:/fav?chef=1";
    }
}
