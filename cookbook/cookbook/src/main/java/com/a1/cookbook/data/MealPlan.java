package com.a1.cookbook.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MEAL_PLAN")
public class MealPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="MEAL_PLAN_ID")
    private long id;

    @Column(name="RECIPE_ID")
    private Long recipeId;

    @Column(name="CHEF_ID")
    private Long chefId;

    @Column(name="MEAL_PLAN_DATE")
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
