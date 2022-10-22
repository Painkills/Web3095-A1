package com.a1.cookbook.data;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="MEAL_PLAN")
@SQLDelete(sql = "UPDATE MEAL_PLAN SET DELETED = true WHERE RECIPE_ID=?")
@Where(clause = "deleted=false")
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
