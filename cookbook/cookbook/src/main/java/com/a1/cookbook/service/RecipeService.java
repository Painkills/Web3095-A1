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
    private final RecipeBuilder builder;

    public RecipeService(RecipeRepo recipeRepo, RecipeBuilder builder) {
        this.recipeRepo = recipeRepo;
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
