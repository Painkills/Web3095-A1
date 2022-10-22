package com.a1.cookbook.util;

import com.a1.cookbook.data.*;
import com.a1.cookbook.service.PlannedMeal;
import com.a1.cookbook.service.PlannedMealService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final ChefRepo chefRepo;
    private final RecipeRepo recipeRepo;
    private final MealPlanRepo mealPlanRepo;
    private final FavoriteRepo favoriteRepo;
    private final PlannedMealService planService;

    public AppStartupEvent(ChefRepo chefRepo, RecipeRepo recipeRepo, MealPlanRepo mealPlanRepo, FavoriteRepo favoriteRepo, PlannedMealService planService) {
        this.chefRepo = chefRepo;
        this.recipeRepo = recipeRepo;
        this.mealPlanRepo = mealPlanRepo;
        this.favoriteRepo = favoriteRepo;
        this.planService = planService;
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
        chefs.forEach(chef -> {
            System.out.println(chef.getFirstName());
            Map<LocalDate, List<PlannedMeal>> plans = planService.getPlannedMealsByIdAndDate(chef.getId(), LocalDate.parse("2022-10-20"));
            plans.values().forEach(System.out::println);
        });
    }
}
