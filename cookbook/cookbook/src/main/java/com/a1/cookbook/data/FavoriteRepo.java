package com.a1.cookbook.data;

import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepo extends CrudRepository<Favorite, Long> {
    Iterable<Recipe> findFavoritesByChefId(Long chefId);
}
