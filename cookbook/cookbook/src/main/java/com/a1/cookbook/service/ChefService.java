package com.a1.cookbook.service;

import com.a1.cookbook.data.*;
import org.springframework.stereotype.Service;

import java.util.*;



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
}
