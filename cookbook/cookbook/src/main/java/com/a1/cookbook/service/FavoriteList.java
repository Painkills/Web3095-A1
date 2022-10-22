package com.a1.cookbook.service;

public class FavoriteList {
    private long chefId;
    private String chefName;
    private String chefLastname;
    private long RecipeId;
    private String recipeName;
    private String recipeCategory;

    public long getChefId() {
        return chefId;
    }

    public void setChefId(long chefId) {
        this.chefId = chefId;
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

    @Override
    public String toString() {
        return "FavoriteList{" +
                "chefId=" + chefId +
                ", chefName='" + chefName + '\'' +
                ", chefLastname='" + chefLastname + '\'' +
                ", RecipeId=" + RecipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeCategory='" + recipeCategory + '\'' +
                '}';
    }
}
