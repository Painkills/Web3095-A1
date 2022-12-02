//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: November 28, 2022
//        * Description: This interface establishes the repository layer, which deals with all communications between
//                        POJOs, and the database. By extending CrudRepository we get access to all of the builitin
//                        methods that it has, which facilitates CRUD operations.
//*********************************************************************************

package com.a1.cookbook.data;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepo extends CrudRepository<Ingredient, Long> {
    Ingredient findIngredientByIngredientName(String ingredientName);

    //Iterable<Ingredient> findIngredientByRecipeId(Long recipeId);
}
