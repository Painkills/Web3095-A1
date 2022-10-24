//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: October 14, 2022
//        * Description: This interface establishes the repository layer, which deals with all communications between
//                        POJOs, and the databse. By extending CrudRepository we get access to all of the builitin
//                        methods that it has, which facilitates CRUD operations. I've added a specific method which
//                        CrudRepo helps me build due to the requirements of Recipes.
//*********************************************************************************

package com.a1.cookbook.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends CrudRepository<Recipe, Long> {
    Iterable<Recipe> findRecipesByCreatorId(@Param("creatorId") Long creatorId);
}
