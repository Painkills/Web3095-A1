package com.a1.cookbook.data;

import javax.persistence.*;

@Entity
@Table(name="CHEF_INGREDIENT")
public class ListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CHEF_INGREDIENT_ID")
    private long id;

    @Column(name="CHEF_ID")
    private Long chefId;

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

    public Long getChefId() {
        return chefId;
    }

    public void setChefId(Long chefId) {
        this.chefId = chefId;
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
        return "ChefIngredient{" +
                "id=" + id +
                ", chefId=" + chefId +
                ", ingredientId=" + ingredientId +
                ", deleted=" + deleted +
                '}';
    }
}
