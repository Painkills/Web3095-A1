package com.a1.cookbook.data;

import org.springframework.data.repository.CrudRepository;

public interface Recipe_IngredientRepo extends CrudRepository<Recipe_Ingredient, Long> {
    Iterable<Recipe_Ingredient> findRecipe_IngredientByRecipeId(Long recipeId);
}
