package com.a1.cookbook.data;

import org.springframework.data.repository.CrudRepository;

public interface RecipeIngredientRepo extends CrudRepository<RecipeIngredient, Long> {
    Iterable<RecipeIngredient> findRecipe_IngredientByRecipeId(Long recipeId);


}
