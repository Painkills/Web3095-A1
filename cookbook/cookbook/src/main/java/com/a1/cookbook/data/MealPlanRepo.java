package com.a1.cookbook.data;

import org.springframework.data.repository.CrudRepository;

public interface MealPlanRepo extends CrudRepository<MealPlan, Long> {
    Iterable<MealPlan> findMealPlanByChefId(Long ChefId);
}
