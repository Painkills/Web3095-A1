package com.a1.cookbook.service;

import com.a1.cookbook.data.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;



@Service
public class ChefListService {

    private final ChefRepo chefRepo;

    public ChefListService(ChefRepo chefRepo) {
        this.chefRepo = chefRepo;
    }
    public List<ChefList> getChef(Long chefId, String password){

        List<ChefList> chefList = new ArrayList<>();
        ChefList theChef = new ChefList();

            boolean something = false;
            Optional<Chef> FoundChefId = this.chefRepo.findById(chefId);
            Chef locatedChef = FoundChefId.orElseGet(FoundChefId::orElseThrow);
            theChef.setChefId(locatedChef.getId());
            theChef.setChefName(locatedChef.getFirstName());
            theChef.setChefLastname(locatedChef.getLastName());
            theChef.setEmail(locatedChef.getEmail());
            theChef.setPassword(locatedChef.getPassword());
            chefList.add(theChef);
        return chefList;

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
