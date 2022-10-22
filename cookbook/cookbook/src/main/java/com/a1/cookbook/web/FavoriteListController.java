package com.a1.cookbook.web;

import com.a1.cookbook.data.Recipe;
import com.a1.cookbook.service.FavoriteListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/fav")
public class FavoriteListController {
    public final FavoriteListService favService;

    public FavoriteListController(FavoriteListService favService) {
        this.favService = favService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getFavorites(@RequestParam(value = "chef")String chef, Model model) {
        Long chefId = Long.decode(chef);
        List<Recipe> favRecipes = this.favService.getFavoriteRecipesByChef(chefId);
        model.addAttribute("favRecipes", favRecipes);
        return "favList";
    }
}
