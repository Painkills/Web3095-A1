//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: October 21, 2022
//        * Description: This class contains the methods that will be used by the Favorite Controller, pulling data
//        from both the recipe and favorite repos in order to be able to provide all recipes, both those made by the user
//        and those they've favorited. It also uses the RecipeBuilder to get the names of the recipe creators.
//*********************************************************************************

package com.a1.cookbook.service;


import com.a1.cookbook.data.Favorite;
import com.a1.cookbook.data.FavoriteRepo;
import com.a1.cookbook.data.Recipe;
import com.a1.cookbook.data.RecipeRepo;
import com.a1.cookbook.util.RecipeBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FavService {

    private final RecipeRepo recipeRepo;
    private final FavoriteRepo favoriteRepo;
    private final RecipeBuilder builder;

    public FavService(RecipeRepo recipeRepo, FavoriteRepo favoriteRepo, RecipeBuilder builder) {
        this.recipeRepo = recipeRepo;
        this.favoriteRepo = favoriteRepo;
        this.builder = builder;
    }

    public List<CompleteRecipe> getFavoriteRecipesByChef(Long chefId) {
        // Initialize list of recipes
        List<CompleteRecipe> allFavList = new ArrayList<>();

//        // Get recipes created by the current chef by filtering by creatorId
//        Iterable<Recipe> allRecipes = recipeRepo.findRecipesByCreatorId(chefId);
//
//        // Build into "complete recipe" that contains creator name and id if not deleted
//        allRecipes.forEach(recipe -> {
//            if (!recipe.isDeleted()) allFavList.add(builder.buildCompleteRecipe(recipe));
//        });

        // Get recipes favorited by the Chef
        Iterable<Favorite> favList = favoriteRepo.findFavoritesByChefId(chefId);
        favList.forEach(favorite -> {
            // Locate the recipe the favorite refers to
            Recipe recipe = recipeRepo.findById(favorite.getRecipeId()).get();

            // If the recipe isn't one already added above, and not deleted, build and add it to All Favorites
            if (Objects.equals(favorite.getChefId(), chefId)) {
                if (!favorite.isDeleted()) allFavList.add(builder.buildCompleteRecipe(recipe));
            }
        });
        return allFavList;
    }

    public Recipe getRecipeById(Long recipeId) {
        return this.recipeRepo.findById(recipeId).get();
    }

    public Favorite saveOrUpdate(Long chefId, Long recipeId) {
        Favorite fav = new Favorite();
        fav.setChefId(chefId);
        fav.setRecipeId(recipeId);
        return favoriteRepo.save(fav);
    }

    public void deleteFav(Long chefId, Long recipeId) {
        // Soft delete the fav
        Favorite favorite = this.favoriteRepo.findFavoriteByChefIdAndRecipeId(chefId, recipeId);
        favorite.setDeleted(true);
        this.favoriteRepo.save(favorite);
    }
}
