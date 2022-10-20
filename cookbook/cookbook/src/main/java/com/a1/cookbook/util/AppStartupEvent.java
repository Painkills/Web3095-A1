package com.a1.cookbook.util;

import com.a1.cookbook.data.Chef;
import com.a1.cookbook.data.ChefRepo;
import com.a1.cookbook.data.Recipe;
import com.a1.cookbook.data.RecipeRepo;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final ChefRepo chefRepo;
    private final RecipeRepo recipeRepo;

    public AppStartupEvent(ChefRepo chefRepo, RecipeRepo recipeRepo) {
        this.chefRepo = chefRepo;
        this.recipeRepo = recipeRepo;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Chef> chefs = this.chefRepo.findAll();
        chefs.forEach(System.out::println);
        Iterable<Recipe> recipes = this.recipeRepo.findAll();
        recipes.forEach(System.out::println);
    }
}
