//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: October 21, 2022
//        * Description: This class builds up from a basic recipe, a completed recipe as per the CompeltedRecipe class. This is leveraged
//        by the Recipe and Favorite Services through the RecipeBuilder Util in order to deliver complete recipes to the frontend.
//*********************************************************************************

package com.a1.cookbook.util;

import com.a1.cookbook.data.*;
import com.a1.cookbook.service.CompleteRecipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBuilder {
    private final ChefRepo chefRepo;
    private final Recipe_IngredientRepo recIngRepo;
    private final IngredientRepo ingRepo;

    public RecipeBuilder(ChefRepo chefRepo, Recipe_IngredientRepo recIngRepo, IngredientRepo ingRepo) {
        this.chefRepo = chefRepo;
        this.recIngRepo = recIngRepo;
        this.ingRepo = ingRepo;
    }

    public CompleteRecipe buildCompleteRecipe(Recipe recipe) {
        // initialize the completed recipe
        CompleteRecipe completeRecipe = new CompleteRecipe();

        // get the full name of the recipe's creator
        Optional<Chef> chef = this.chefRepo.findById(recipe.getCreatorId());
        Chef locatedChef = chef.orElseGet(chef::orElseThrow);
        String chefName = locatedChef.getFirstName() + " " + locatedChef.getLastName();

        completeRecipe.setRecipeId(recipe.getId());
        completeRecipe.setRecipeName(recipe.getName());
        completeRecipe.setRecipeCategory(recipe.getCategory());

        // get all ingredients for a recipe
        Iterable<Recipe_Ingredient> recipeIngredients = this.recIngRepo.findRecipe_IngredientByRecipeId(recipe.getId());
        List<String> ingredientList = new ArrayList<>();
        recipeIngredients.forEach(recipe_ingredient -> {
            Optional<Ingredient> ingredient = this.ingRepo.findById(recipe_ingredient.getRecipeId());
            Ingredient locatedIngredient = ingredient.orElseGet(ingredient::orElseThrow);
            if (!locatedIngredient.isDeleted()) {
                ingredientList.add(locatedIngredient.getIngredientName());
            }
        });
        completeRecipe.setRecipeIngredients(ingredientList);
        completeRecipe.setRecipeInstructions(recipe.getInstructions());
        completeRecipe.setCreatorId(recipe.getCreatorId());
        completeRecipe.setCreatorName(chefName);

        return completeRecipe;
    }
}
