//* Project: < cookbook.a1.com >
//		* Assignment: Comp 3095 #1
//		* Author(s): David Fortich, Mitesh Mitry, Ronal Rodriguez, Lemuel Javier
//		* Student Number: 101314570, 101248745, 101314540, 101168735
//		* Date: October 14, 2022
//		* Description: The controller maps the requests related to favorite recipes and passes them to the service.

package com.a1.cookbook.web;

import com.a1.cookbook.service.ChefService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
    public final ChefService chefService;

    public LoginController(ChefService chefService) {
        this.chefService = chefService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcomePage(Model model, @RequestParam String email, String password){
        RedirectView redirectView = new RedirectView();
        if(!password.isEmpty() && !email.isEmpty()){
            boolean theChef = this.chefService.checkLogin(email, password);
            String chefName = "";
            Long chefId;
            System.out.println(theChef);
            if(theChef){
                chefName = chefService.returnName(email);
                chefId = chefService.returnId(email);
                model.addAttribute("theChef", chefName);
                model.addAttribute("ChefId", chefId);
                return "welcome";
            }else{
                return "login";
            }
        }else{
            return "login";
        }
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomePage() {

        return "welcome";
    }

    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
