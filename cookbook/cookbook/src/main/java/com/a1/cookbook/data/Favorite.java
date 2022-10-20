package com.a1.cookbook.data;

import javax.persistence.*;

@Entity
@Table(name="CHEF_RECIPE")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CHEF_RECIPE_ID")
    private Long id;

    @Column(name="RECIPE_ID")
    private Long recipeId;

    @Column(name="CHEF_ID")
    private Long chefId;
}
