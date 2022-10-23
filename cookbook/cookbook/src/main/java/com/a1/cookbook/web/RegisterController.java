package com.a1.cookbook.web;

import com.a1.cookbook.service.ChefListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    public final ChefListService chefListService;

    public RegisterController(ChefListService chefListService) {
        this.chefListService = chefListService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String registerPage(){
        return "register";
    }

    @RequestMapping(value= {"", "/"}, method = RequestMethod.POST)
    public String registerCheckPage(@RequestParam String email, @RequestParam String fName, @RequestParam String lName,@RequestParam String password){
        this.chefListService.addChef(fName, lName, email, password);
        return "login";
    }
}
