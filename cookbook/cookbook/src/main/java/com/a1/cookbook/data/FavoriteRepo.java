//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: October 14, 2022
//        * Description: This interface establishes the repository layer, which deals with all communications between
//                        POJOs, and the databse. By extending CrudRepository we get access to all of the builitin
//                        methods that it has, which facilitates CRUD operations. I've added some specific methods which
//                        CrudRepo helps me build due to the requirements of Favorites.
//*********************************************************************************

package com.a1.cookbook.data;

import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepo extends CrudRepository<Favorite, Long> {
    Iterable<Favorite> findFavoritesByChefId(Long chefId);
    Favorite findFavoriteByChefIdAndRecipeId(Long chefId, Long recipeId);
}
