package com.a1.cookbook.data;

import org.springframework.data.repository.CrudRepository;

public interface ListItemRepo extends CrudRepository<ListItem, Long> {
    Iterable<ListItem> findListItemsByChefId(Long chefId);
    ListItem findListItemByChefIdAndIngredientId(Long chefId, Long ingredientId);
}
