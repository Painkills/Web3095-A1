//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: October 21, 2022
//        * Description: This class contains the methods that will be used by the Recipe Controller, pulling data
//        from the recipe repo in order to be able to provide all recipes, while using the recipe builder to include
//        the creator's name and not just id.
//*********************************************************************************

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
    private final Recipe_IngredientRepo recIngRepo;
    private final IngredientRepo ingRepo;
    private final RecipeBuilder builder;

    public RecipeService(RecipeRepo recipeRepo, Recipe_IngredientRepo recIngRepo, IngredientRepo ingRepo, RecipeBuilder builder) {
        this.recipeRepo = recipeRepo;
        this.recIngRepo = recIngRepo;
        this.ingRepo = ingRepo;
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

    public CompleteRecipe getCompleteRecipeById(Long recipeId) {
        Recipe recipe = this.recipeRepo.findById(recipeId).get();
        return this.builder.buildCompleteRecipe(recipe);
    }

    public Recipe getRecipeById(Long recipeId) {
        return this.recipeRepo.findById(recipeId).get();
    }

    public void save(String name, String category, List<String> ingredients, String instructions, Long id) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setCategory(category);
        recipe.setInstructions(instructions);
        recipe.setCreatorId(id);
        // save the recipe into recipeRepo
        recipe = recipeRepo.save(recipe);
        // Once created, take its Id
        Long recipeId = recipe.getId();

        // Get / create Ids for ingredient list passed by user
        List<Long> ingredientIds = new ArrayList<>();
        ingredients.forEach(ingredient -> {
            // Deal with diff spelling / capitalization / spacing from existing ingNames
            String cleanIngredientName = ingredient.trim().toLowerCase();

            // Search for the ingredient
            Ingredient locatedIngredient = this.ingRepo.findIngredientByIngredientName(cleanIngredientName);
            System.out.println("Located Ingredient: " + locatedIngredient);
            // If null, create a new one and get id
            if (locatedIngredient == null) {
                Ingredient newIngredient = new Ingredient();
                newIngredient.setIngredientName(cleanIngredientName);
                ingRepo.save(newIngredient);
                ingredientIds.add(newIngredient.getId());

            // If it exists, get its id
            } else {
                ingredientIds.add(locatedIngredient.getId());
            }
        });

        // Add them to recipe_has_ingredientRepo
        ingredientIds.forEach(ingredientId -> {
            System.out.println("Id I'm adding is: " + ingredientId);
            Recipe_Ingredient recipe_ingredient = new Recipe_Ingredient();
            recipe_ingredient.setRecipeId(recipeId);
            recipe_ingredient.setIngredientId(ingredientId);
            recIngRepo.save(recipe_ingredient);
        });
    }

    public void deleteRecipe(Long recipeId) {
        // Soft delete the recipe
        Recipe recipe = this.recipeRepo.findById(recipeId).get();
        recipe.setDeleted(true);
        this.recipeRepo.save(recipe);
    }
}
