package com.a1.cookbook.util;

import com.a1.cookbook.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final ChefRepo chefRepo;
    private final RecipeRepo recipeRepo;
    private final MealPlanRepo mealPlanRepo;
    private final FavoriteRepo favoriteRepo;

    public AppStartupEvent(ChefRepo chefRepo, RecipeRepo recipeRepo, MealPlanRepo mealPlanRepo, FavoriteRepo favoriteRepo) {
        this.chefRepo = chefRepo;
        this.recipeRepo = recipeRepo;
        this.mealPlanRepo = mealPlanRepo;
        this.favoriteRepo = favoriteRepo;

    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Chef> chefs = this.chefRepo.findAll();
        chefs.forEach(System.out::println);
        Iterable<Recipe> recipes = this.recipeRepo.findAll();
        recipes.forEach(System.out::println);
        Iterable<MealPlan> mealPlans = this.mealPlanRepo.findAll();
        mealPlans.forEach(System.out::println);
        Iterable<Favorite> favorites = this.favoriteRepo.findAll();
        favorites.forEach(System.out::println);
    }
}
