package com.a1.cookbook.web;

import com.a1.cookbook.data.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopListService {
    private final ListItemRepo listItemRepo;
    private final IngredientRepo ingredientRepo;

    public ShopListService(ListItemRepo listItemRepo, IngredientRepo ingredientRepo) {
        this.listItemRepo = listItemRepo;
        this.ingredientRepo = ingredientRepo;
    }

    public List<Ingredient> getShoppingListByChef(Long chefId) {
        // Initialize list of ingredients
        List<Ingredient> shoppingList = new ArrayList<>();

        // Get recipes created by the current chef by filtering by creatorId
        Iterable<ListItem> itemList = this.listItemRepo.findListItemsByChefId(chefId);

        itemList.forEach(item -> {
            // Locate the ingredient
            Optional<Ingredient> ingredient = this.ingredientRepo.findById(item.getIngredientId());
            Ingredient locatedIngredient = ingredient.orElseGet(ingredient::orElseThrow);

            // Add it to the list
            shoppingList.add(locatedIngredient);
        });

        return shoppingList;
    }

    public ListItem saveOrUpdate(Long chefId, Long ingredientId) {
        // Check if that ingredient already existed
        ListItem listItem = this.listItemRepo.findListItemByChefIdAndIngredientId(chefId, ingredientId);

        // If it didn't, add it.
        if (listItem == null) {
            listItem = new ListItem();
            listItem.setChefId(chefId);
            listItem.setIngredientId(ingredientId);
        // If it did and was deleted, undelete it.
        } else {
            listItem.setDeleted(false);
        }
        return listItemRepo.save(listItem);
    }

    public void deleteItem(Long chefId, Long ingredientId) {
        // Soft delete the item from the list
        ListItem listItem = this.listItemRepo.findListItemByChefIdAndIngredientId(chefId, ingredientId);
        listItem.setDeleted(true);
        this.listItemRepo.save(listItem);

    }
}
