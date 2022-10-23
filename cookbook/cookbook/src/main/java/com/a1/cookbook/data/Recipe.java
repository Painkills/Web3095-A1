package com.a1.cookbook.data;

import javax.persistence.*;

@Entity
@Table(name="RECIPE")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private long creatorId;

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

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                ", creator_id=" + creatorId +
                '}';
    }
}
