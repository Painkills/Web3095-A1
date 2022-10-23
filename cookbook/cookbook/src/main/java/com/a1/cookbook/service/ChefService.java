package com.a1.cookbook.service;

import com.a1.cookbook.data.Chef;
import com.a1.cookbook.data.ChefRepo;
import com.a1.cookbook.data.Recipe;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChefService {

    private final ChefRepo chefRepo;

    public ChefService(ChefRepo chefRepo) {
        this.chefRepo = chefRepo;
    }
    public boolean checkLogin(Long chefId, String password){;
        try {

            Optional<Chef> FoundChefId = this.chefRepo.findById(chefId);
            Chef locatedChef = FoundChefId.orElseGet(FoundChefId::orElseThrow);
            return locatedChef.getId() == chefId && locatedChef.getPassword().equals(password);
        }catch(Exception e){
            return false;
        }

    }
    public String returnName(Long chefId){

        Optional<Chef> FoundChefId = this.chefRepo.findById(chefId);
        Chef locatedChef = FoundChefId.orElseGet(FoundChefId::orElseThrow);

        return locatedChef.getFirstName();
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
}
