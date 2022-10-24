//* Project: < cookbook.a1.com >
//		* Assignment: Comp 3095 #1
//		* Author(s): David Fortich, Mitesh Mitry, Ronal Rodriguez, Lemuel Javier
//		* Student Number: 101314570, 101248745, 101314540, 101168735
//		* Date: October 14, 2022
//		* Description: The controller maps the requests related to favorite recipes and passes them to the service.

package com.a1.cookbook.web;

import com.a1.cookbook.service.ChefService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    public final ChefService chefService;

    public RegisterController(ChefService chefService) {
        this.chefService = chefService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String registerPage(){
        return "register";
    }

    @PostMapping(value= {"", "/"})
    public String registerCheckPage(@RequestParam String email, String password, String firstName, String lastName){
        this.chefService.addChef(firstName, lastName, email, password);

        return "redirect:/";
    }
}
