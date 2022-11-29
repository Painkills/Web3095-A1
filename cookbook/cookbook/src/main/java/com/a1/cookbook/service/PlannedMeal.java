//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: October 21, 2022
//        * Description: This class pulls together the information from recipe and chef found in a mealPlan in order to provide
//        a mealPlan that also has the name of the user who created it, and the information of the recipe instead of just the ids. This is leveraged
//        by the PlannedMeal Service.
//*********************************************************************************

package com.a1.cookbook.service;

import java.time.LocalDate;


public class PlannedMeal {
    private long chefId;
    private String chefName;
    private String chefLastname;
    private long RecipeId;
    private String recipeName;
    private String recipeCategory;
    private LocalDate date;

    public long getChefId() {
        return chefId;
    }

    public void setChefId(long chefId) {
        this.chefId = chefId;
    }

    public long getRecipeId() {
        return RecipeId;
    }

    public void setRecipeId(long recipeId) {
        RecipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    public String getChefLastname() {
        return chefLastname;
    }

    public void setChefLastname(String chefLastname) {
        this.chefLastname = chefLastname;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return recipeCategory + ": " + recipeName;
    }
}
