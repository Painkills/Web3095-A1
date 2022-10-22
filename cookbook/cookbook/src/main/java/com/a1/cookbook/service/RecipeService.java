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

        // Build into "complete recipe" that contains creator name and id
        allRecipes.forEach(recipe -> completeRecipes.add(this.builder.buildCompleteRecipe(recipe)));

        return completeRecipes;
    }

    public List<CompleteRecipe> getFavoriteRecipesByChef(Long chefId) {
        // Initialize list of recipes
        List<CompleteRecipe> allFavList = new ArrayList<>();

        // Get recipes created by the current chef by filtering by creatorId
        Iterable<Recipe> allRecipes = this.recipeRepo.findRecipesByCreatorId(chefId);

        // Build into "complete recipe" that contains creator name and id
        allRecipes.forEach(recipe -> allFavList.add(this.builder.buildCompleteRecipe(recipe)));

        // Get recipes favorited by the Chef
        Iterable<Favorite> favList = this.favoriteRepo.findFavoritesByChefId(chefId);
        favList.forEach(favorite -> {
            // Locate the recipe the favorite refers to
            Optional<Recipe> recipe = this.recipeRepo.findById(favorite.getRecipeId());
            Recipe locatedRecipe = recipe.orElseGet(recipe::orElseThrow);

            // If the recipe isn't one already added above, build and add it to All Favorites
            if (!Objects.equals(favorite.getChefId(), chefId)) {
                allFavList.add(this.builder.buildCompleteRecipe(locatedRecipe));
            }
        });
        return allFavList;
    }

    public CompleteRecipe getRecipeById(Long recipeId) {
        Optional<Recipe> recipe = this.recipeRepo.findById(recipeId);
        Recipe locatedRecipe = recipe.orElseGet(recipe::orElseThrow);
        return this.builder.buildCompleteRecipe(locatedRecipe);
    }

    public Recipe addRecipe(String name, String category, String ingredients, String instructions, Long creatorId) {
        Recipe newRecipe = new Recipe();
        newRecipe.setName(name);
        newRecipe.setCategory(category);
        newRecipe.setIngredients(ingredients);
        newRecipe.setInstructions(instructions);
        newRecipe.setId(creatorId);
        return this.recipeRepo.save(newRecipe);
    }

    public boolean deleteRecipe(Long recipeId) {
        this.recipeRepo.deleteById(recipeId);
        return this.recipeRepo.existsById(recipeId);
    }
}
