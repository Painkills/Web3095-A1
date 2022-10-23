package com.a1.cookbook.service;


import com.a1.cookbook.data.*;
import com.a1.cookbook.util.RecipeBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepo recipeRepo;
    private final FavoriteRepo favoriteRepo;
    private final RecipeBuilder builder;

    public RecipeService(RecipeRepo recipeRepo, FavoriteRepo favoriteRepo, RecipeBuilder builder) {
        this.recipeRepo = recipeRepo;
        this.favoriteRepo = favoriteRepo;
        this.builder = builder;
    }

    public List<CompleteRecipe> getAllRecipes(){
        // Initialize list of recipes
        List<CompleteRecipe> completeRecipes = new ArrayList<>();

        // Get recipes created by the current chef by filtering by creatorId
        Iterable<Recipe> allRecipes = this.recipeRepo.findAll();

        // If not deleted, build into "complete recipe" that contains creator name and id
        allRecipes.forEach(recipe -> {
            if(!recipe.isDeleted()) completeRecipes.add(this.builder.buildCompleteRecipe(recipe));
        });

        return completeRecipes;
    }

    public List<CompleteRecipe> getFavoriteRecipesByChef(Long chefId) {
        // Initialize list of recipes
        List<CompleteRecipe> allFavList = new ArrayList<>();

        // Get recipes created by the current chef by filtering by creatorId
        Iterable<Recipe> allRecipes = recipeRepo.findRecipesByCreatorId(chefId);

        // Build into "complete recipe" that contains creator name and id if not deleted
        allRecipes.forEach(recipe -> {
            if (!recipe.isDeleted()) allFavList.add(builder.buildCompleteRecipe(recipe));
        });

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

    public CompleteRecipe getCompleteRecipeById(Long recipeId) {
        Recipe recipe = this.recipeRepo.findById(recipeId).get();
        return this.builder.buildCompleteRecipe(recipe);
    }

    public Recipe getRecipeById(Long recipeId) {
        return this.recipeRepo.findById(recipeId).get();
    }

    public Recipe saveOrUpdate(String name, String category, String ingredients, String instructions, Long id) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setCategory(category);
        recipe.setIngredients(ingredients);
        recipe.setInstructions(instructions);
        recipe.setCreatorId(id);
        System.out.println(recipe);
        return recipeRepo.save(recipe);
    }

    public void deleteRecipe(Long recipeId) {
        // Soft delete the recipe
        Recipe recipe = this.recipeRepo.findById(recipeId).get();
        recipe.setDeleted(true);
        this.recipeRepo.save(recipe);
    }
}
