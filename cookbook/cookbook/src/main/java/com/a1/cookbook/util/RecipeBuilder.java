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

import com.a1.cookbook.data.Chef;
import com.a1.cookbook.data.ChefRepo;
import com.a1.cookbook.data.Recipe;
import com.a1.cookbook.service.CompleteRecipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBuilder {
    private final ChefRepo chefRepo;

    public RecipeBuilder(ChefRepo chefRepo) {
        this.chefRepo = chefRepo;
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
        completeRecipe.setRecipeIngredients(recipe.getIngredients());
        completeRecipe.setRecipeInstructions(recipe.getInstructions());
        completeRecipe.setCreatorId(recipe.getCreatorId());
        completeRecipe.setCreatorName(chefName);

        return completeRecipe;
    }
}
