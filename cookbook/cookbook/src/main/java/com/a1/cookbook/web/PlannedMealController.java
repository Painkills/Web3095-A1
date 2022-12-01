//* Project: < cookbook.a1.com >
//		* Assignment: Comp 3095 #1
//		* Author(s): David Fortich, Mitesh Mitry, Ronal Rodriguez, Lemuel Javier
//		* Student Number: 101314570, 101248745, 101314540, 101168735
//		* Date: October 14, 2022
//		* Description: The controller maps the requests related to favorite recipes and passes them to the service.

package com.a1.cookbook.web;

import com.a1.cookbook.service.PlannedMeal;
import com.a1.cookbook.service.PlannedMealService;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
        LocalDate date;
        date = (dateString == null)? LocalDate.now() : LocalDate.parse(dateString);

        Map<LocalDate, List<PlannedMeal>> mealPlans = this.mealService.getPlannedMealsByIdAndDate(chefId, date);
        model.addAttribute("mealPlans", mealPlans);
        return "mealPlanner";
    }

    @PostMapping("/delete")
    private String deletePlan(@RequestParam("id") String recipeAndChefIds) {
        String[] values = recipeAndChefIds.split(";");
        Long recipeId = Long.parseLong(values[0]);
        Long chefId = Long.parseLong(values[0]);
        LocalDate date = LocalDate.of(2022, 12, 4);
        this.mealService.deletePlan(chefId, recipeId, date);
        return "/";
    }
}
