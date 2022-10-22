package com.a1.cookbook.web;

import com.a1.cookbook.service.PlannedMeal;
import com.a1.cookbook.service.PlannedMealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String getPlans(Model model) {
        Map<LocalDate, List<PlannedMeal>> mealPlans = this.mealService.getPlannedMealsByIdAndDate(2L, LocalDate.parse("2022-10-20"));
        model.addAttribute("mealPlans", mealPlans);
        return "mealPlanner";
    }
}
