//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 2
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: November 28, 2022
//        * Description: This is the INGREDIENT entity, which establishes the table name and columns for the database to use,
//                        but also has attributes and basic get/set methods since it is a POJO. It is managed by Spring.
//                        This is a table that holds all the ingredients to be used by recipes and shopping lists.
//*********************************************************************************

package com.a1.cookbook.data;

import javax.persistence.*;

@Entity
@Table(name="INGREDIENT")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INGREDIENT_ID")
    private Long id;

    @Column(name ="INGREDIENT_NAME")
    private String ingredientName;

    @Column(name ="DELETED")
    private boolean deleted = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
