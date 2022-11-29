package com.a1.cookbook.data;

import javax.persistence.*;

@Entity
@Table(name="RECIPE_HAS_INGREDIENT")
public class Recipe_Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RECIPE_HAS_INGREDIENT_ID")
    private long id;

    @Column(name="RECIPE_ID")
    private Long recipeId;

    @Column(name="INGREDIENT_ID")
    private Long ingredientId;

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

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Recipe_Ingredient{" +
                "id=" + id +
                ", recipeId=" + recipeId +
                ", ingredientId=" + ingredientId +
                ", deleted=" + deleted +
                '}';
    }
}
