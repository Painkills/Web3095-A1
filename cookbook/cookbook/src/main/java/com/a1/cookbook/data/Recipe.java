//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: October 14, 2022
//        * Description: This is the RECIPE entity, which establishes the table name and columns for the database to use,
//                        but also has attributes and basic get/set methods since it is a POJO. It is managed by Spring.
//*********************************************************************************


package com.a1.cookbook.data;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Table(name="RECIPE")
@SQLDelete(sql = "UPDATE RECIPE SET DELETED = true WHERE RECIPE_ID=?")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RECIPE_ID")
    private long id;

    @Column(name="RECIPE_NAME")
    private String name;

    @Column(name="CATEGORY")
    private String category;

    @Column(name = "INGREDIENTS")
    private String ingredients;

    @Column(name = "INSTRUCTIONS")
    private String instructions;

    @Column(name = "CREATOR_ID")
    private Long creatorId;

    @Column(name = "DELETED")
    private boolean deleted = Boolean.FALSE;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", creator_id=" + creatorId +
                ", deleted?=" + isDeleted() +
                '}';
    }
}
