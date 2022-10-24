//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): David Fortich
//        * Student Number: 101314570
//        * Date: October 14, 2022
//        * Description: This is the FAVORITE entity, which establishes the table name and columns for the database to use,
//                        but also has attributes and basic get/set methods since it is a POJO. It is managed by Spring.
//                        This is a linking table between Chef and Recipe.
//*********************************************************************************

package com.a1.cookbook.data;

import javax.persistence.*;

@Entity
@Table(name="FAVORITE")
//@SQLDelete(sql = "UPDATE FAVORITE SET DELETED = true WHERE RECIPE_ID=?")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="FAVORITE_ID")
    private Long id;

    @Column(name="RECIPE_ID")
    private Long recipeId;

    @Column(name="CHEF_ID")
    private Long chefId;

    @Column(name = "DELETED")
    private boolean deleted = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", recipeId=" + recipeId +
                ", chefId=" + chefId +
                '}';
    }
}
