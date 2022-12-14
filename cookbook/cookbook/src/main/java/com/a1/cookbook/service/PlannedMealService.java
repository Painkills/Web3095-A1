//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: October 21, 2022
//        * Description: This class contains the methods that will be used by the PlannedMeal Controller, pulling data
//        from both the recipe, chef and mealPlan repos in order to be able to provide the table organized by date for
//        each user containing the recipes they've planned for that date.'
//*********************************************************************************

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
            // Only process mealPlan if it is within one week of requested date range or not deleted
            if (mealPlan.getDate().isBefore(requestedDate) || mealPlan.getDate().isAfter(endDate.minusDays(1)) || mealPlan.isDeleted()) {
                return;
            }
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

    public MealPlan saveOrUpdate(Long chefId, Long recipeId, LocalDate date){
        MealPlan mealPlan = new MealPlan();
        mealPlan.setChefId(chefId);
        mealPlan.setRecipeId(recipeId);
        mealPlan.setDate(date);
        return this.mealPlanRepo.save(mealPlan);
    }

    public void deletePlan(Long chefId, Long recipeId, LocalDate date) {
        // Soft delete the fav
        MealPlan plan = this.mealPlanRepo.findMealPlanByChefIdAndAndRecipeIdAndDate(chefId, recipeId, date);
        plan.setDeleted(true);
        this.mealPlanRepo.save(plan);
    }
}

