package com.a1.cookbook.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends CrudRepository<Recipe, Long> {
    Iterable<Recipe> findRecipesByCreator_id(@Param("creatorId") Long creatorId);
}
