package com.a1.cookbook.web;

import com.a1.cookbook.service.ShopListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
//@RequestMapping("/ingredients")
//public class IngredientsController {
//    public final ShopListService shopListService;
//    public IngredientsController(ShopListService shopListService) { this.shopListService = shopListService; }
//
//    @PostMapping(value = {"/addToShopList"})
//    private String addToShopList(@RequestParam("id") String chefIngredientAndRecipeIds) {
//        String[] values = chefIngredientAndRecipeIds.split(";");
//        Long chefId = Long.parseLong(values[0]);
//        Long ingredientId = Long.parseLong(values[1]);
//        int recipeId = Integer.parseInt(values[2]);
//        shopListService.saveOrUpdate(chefId, ingredientId);
//        return "redirect:recipe/viewIngredients?=" + recipeId;
//    }
//}
