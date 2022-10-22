package com.a1.cookbook.service;


import com.a1.cookbook.data.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FavoriteListService {
    private final ChefRepo chefRepo;
    private final RecipeRepo recipeRepo;
    private final FavoriteRepo favoriteRepo;

    public FavoriteListService(ChefRepo chefRepo, RecipeRepo recipeRepo, FavoriteRepo favoriteRepo) {
        this.chefRepo = chefRepo;
        this.recipeRepo = recipeRepo;
        this.favoriteRepo = favoriteRepo;
    }

    public List<Recipe> getFavoriteRecipesByChef(Long chefId) {
        // Initialize list of recipes
        List<Recipe> allFavList = new ArrayList<>();

        // Get recipes made by the chef by filtering by creatorId
        Iterable<Recipe> allRecipes = this.recipeRepo.findRecipesByCreatorId(chefId);
        allRecipes.forEach(allFavList::add);

        // Get recipes favorited by the Chef
        Iterable<Favorite> favList = this.favoriteRepo.findFavoritesByChefId(chefId);
        favList.forEach(favorite -> {
            Optional<Recipe> recipe = this.recipeRepo.findById(favorite.getRecipeId());
            Recipe locatedRecipe = recipe.orElseGet(recipe::orElseThrow);
            if (!Objects.equals(favorite.getChefId(), chefId)) {
                allFavList.add(locatedRecipe);
            }
        });


        return allFavList;
    }
}
