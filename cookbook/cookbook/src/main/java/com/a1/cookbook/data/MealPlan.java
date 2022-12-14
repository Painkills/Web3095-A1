//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: October 14, 2022
//        * Description: This is the MEAL_PLAN entity, which establishes the table name and columns for the database to use,
//                        but also has attributes and basic get/set methods since it is a POJO. It is managed by Spring.
//                        This is a linking table between Chef and Recipe, but also includes a date.
//*********************************************************************************


package com.a1.cookbook.data;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="MEAL_PLAN")
//@SQLDelete(sql = "UPDATE MEAL_PLAN SET DELETED = true WHERE RECIPE_ID=?")
public class MealPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEAL_PLAN_ID")
    private long id;

    @Column(name="RECIPE_ID")
    private Long recipeId;

    @Column(name="CHEF_ID")
    private Long chefId;

    @Column(name="MEAL_PLAN_DATE")
    private LocalDate date;

    @Column(name = "DELETED")
    private boolean deleted = Boolean.FALSE;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getChefId() {
        return chefId;
    }

    public void setChefId(Long chefId) {
        this.chefId = chefId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "id=" + id +
                ", recipeId=" + recipeId +
                ", chefId=" + chefId +
                ", date=" + date +
                '}';
    }
}
