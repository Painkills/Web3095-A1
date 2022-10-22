package com.a1.cookbook.web;

import com.a1.cookbook.data.MealPlan;
import com.a1.cookbook.service.PlannedMeal;
import com.a1.cookbook.service.PlannedMealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/plan")
public class PlannedMealController {
    public final PlannedMealService mealService;

    public PlannedMealController(PlannedMealService mealService) {
        this.mealService = mealService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getPlans(@RequestParam(value = "chef")String chef, @RequestParam(value="date", required = false) String dateString, Model model) {
        Long chefId = Long.parseLong(chef);
        System.out.println(chefId);
        System.out.println(dateString);
        Map<LocalDate, List<PlannedMeal>> mealPlans = this.mealService.getPlannedMealsByIdAndDate(chefId, LocalDate.parse(dateString));
        model.addAttribute("mealPlans", mealPlans);
        return "mealplanner";
    }
}
