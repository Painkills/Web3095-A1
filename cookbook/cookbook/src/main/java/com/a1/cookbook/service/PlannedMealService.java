package com.a1.cookbook.service;

import com.a1.cookbook.data.*;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.time.LocalDate;
import java.util.*;

@Service
public class PlannedMealService {
    private final ChefRepo chefRepo;
    private final RecipeRepo recipeRepo;
    private final MealPlanRepo mealPlanRepo;

    public PlannedMealService(ChefRepo chefRepo, RecipeRepo recipeRepo, MealPlanRepo mealPlanRepo) {
        this.chefRepo = chefRepo;
        this.recipeRepo = recipeRepo;
        this.mealPlanRepo = mealPlanRepo;
    }

    public Map<LocalDate, List<PlannedMeal>> getPlannedMealsByIdAndDate(Long chefId, LocalDate requestedDate) {
        // Get chef
        Optional<Chef> chef = this.chefRepo.findById(chefId);
        Chef locatedChef = chef.orElseGet(chef::orElseThrow);

        // Check Planned Meals for a week from the chosen date
        LocalDate endDate = requestedDate.plusDays(7);

        // Create Map to hold all sets of planned meals for the period by date
        Map<LocalDate, List<PlannedMeal>> plannedMealMap = new LinkedHashMap<>();
        for (LocalDate startDate = requestedDate; startDate.isBefore(endDate); startDate = startDate.plusDays(1)) {
            // Create an array of meals for the day
            List<PlannedMeal> plannedMeals = new ArrayList<>();
            // Place the array in the hash using date as key
            plannedMealMap.put(startDate, plannedMeals);
        }

        // get all MealPlans for the chef and put them in the corresponding arrays in plannedMealMap by date
        Iterable<MealPlan> mealPlans = this.mealPlanRepo.findMealPlanByChefId(chefId);
        mealPlans.forEach(mealPlan -> {
            // Get recipe
            Optional<Recipe> recipe = this.recipeRepo.findById(mealPlan.getRecipeId());
            Recipe locatedRecipe = recipe.orElseGet(recipe::orElseThrow);
            // retrieve the list of meals for the day
            List<PlannedMeal> plannedMeals = plannedMealMap.get(mealPlan.getDate());
            // create a new meal
            PlannedMeal meal = new PlannedMeal();
            // fill it up
            meal.setDate(mealPlan.getDate());
            meal.setRecipeId(mealPlan.getRecipeId());
            meal.setRecipeName(locatedRecipe.getName());
            meal.setRecipeCategory(locatedRecipe.getCategory());
            meal.setChefId(chefId);
            meal.setChefName(locatedChef.getFirstName());
            meal.setChefLastname(locatedChef.getLastName());
            // add it to the list of meals for that day
            plannedMeals.add(meal);
        });
        return plannedMealMap;
    }
}

