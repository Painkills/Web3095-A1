package com.a1.cookbook.data;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name="FAVORITE")
@SQLDelete(sql = "UPDATE FAVORITE SET DELETED = true WHERE RECIPE_ID=?")
@Where(clause = "deleted=false")
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

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", recipeId=" + recipeId +
                ", chefId=" + chefId +
                '}';
    }
}
