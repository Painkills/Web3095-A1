//*********************************************************************************
// * Project: Cookbook
//        * Assignment: Assignment 1
//        * Author(s): Ronal Rodriguez
//        * Student Number: 101314570
//        * Date: October 22, 2022
//        * Description: This class consolidates the methods that will be needed when managing Chefs in the
//        Login and Register actions through their respective controllers.
//*********************************************************************************

package com.a1.cookbook.service;

import com.a1.cookbook.data.Chef;
import com.a1.cookbook.data.ChefRepo;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ChefService{
    private final ChefRepo chefRepo;

    public ChefService(ChefRepo chefRepo) {
        this.chefRepo = chefRepo;
    }
    public boolean checkLogin(String email, String password){
        AtomicBoolean trueOrFalse = new AtomicBoolean(false);
        try {
//            Iterable<Recipe> allRecipes = this.recipeRepo.findAll();
//
//            // If not deleted, build into "complete recipe" that contains creator name and id
//            allRecipes.forEach(recipe -> {
//                if(!recipe.isDeleted()) completeRecipes.add(this.builder.buildCompleteRecipe(recipe));
//            });
            Iterable<Chef> FoundChefId = this.chefRepo.findAll();
            FoundChefId.forEach(chef -> {
                if(Objects.equals(chef.getEmail(), email) && Objects.equals(chef.getPassword(), password)){
                    trueOrFalse.set(true);
                }
            });
        }catch(Exception e){
            return false;
        }
        return trueOrFalse.get();
    }
    public String returnName(String email){
        AtomicReference<Chef> capturedChef = new AtomicReference<>(new Chef());
        Iterable<Chef> FoundChefId = this.chefRepo.findAll();
        FoundChefId.forEach(chef -> {
            System.out.println("this is the foreach email: "+ chef.getEmail()+ " this is the input email" + email);
            if(Objects.equals(chef.getEmail(), email)){
                capturedChef.set(chef);
            }
        });
            return capturedChef.get().getFirstName();
    }
    public Long returnId(String email){
        AtomicReference<Chef> capturedChef = new AtomicReference<>(new Chef());
        Iterable<Chef> FoundChefId = this.chefRepo.findAll();
        FoundChefId.forEach(chef -> {
            System.out.println("this is the foreach email: "+ chef.getEmail()+ " this is the input email" + email);
            if(Objects.equals(chef.getEmail(), email)){
                capturedChef.set(chef);
            }
        });
            return capturedChef.get().getId();
    }

    public Chef addChef(String fName, String lName, String email, String password) {
        long FoundChefId = this.chefRepo.count();
        Chef newChef = new Chef();
        newChef.setId(FoundChefId + 1);
        newChef.setFirstName(fName);
        newChef.setLastName(lName);
        newChef.setEmail(email);
        newChef.setPassword(password);
        System.out.println("This is the way: " + newChef);
        return this.chefRepo.save(newChef);
    }

    public void deleteChef(Long chefId) {
        // Soft delete the recipe
        Chef chef = this.chefRepo.findById(chefId).get();
        chef.setDeleted(true);
        this.chefRepo.save(chef);
    }
    public Boolean updatePassword(String email, String password, String newPassword){
        AtomicBoolean trueOrFalse = new AtomicBoolean(false);
        try {
            Iterable<Chef> FoundChefId = this.chefRepo.findAll();
            FoundChefId.forEach(chef -> {
                if(Objects.equals(chef.getEmail(), email) && Objects.equals(chef.getPassword(), password)){
                    chef.setPassword(newPassword);
                    this.chefRepo.save(chef);
                    trueOrFalse.set(true);
                }

            }
            );
        }catch(Exception e){
            return false;
        }
        return trueOrFalse.get();
    }
    public Boolean forgotPassword(String email, String name, String newPassword){
        AtomicBoolean trueOrFalse = new AtomicBoolean(false);
        try {
            Iterable<Chef> FoundChefId = this.chefRepo.findAll();
            FoundChefId.forEach(chef -> {
                        if(Objects.equals(chef.getEmail(), email) && Objects.equals(chef.getFirstName(), name)){
                            chef.setPassword(newPassword);
                            this.chefRepo.save(chef);
                            trueOrFalse.set(true);
                        }

                    }
            );
        }catch(Exception e){
            return false;
        }
        return trueOrFalse.get();
    }

}
