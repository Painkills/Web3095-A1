package com.a1.cookbook.web;

import com.a1.cookbook.service.ChefList;
import com.a1.cookbook.service.ChefListService;
import com.a1.cookbook.service.PlannedMeal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    public final ChefListService chefListService;

    public LoginController(ChefListService chefListService) {
        this.chefListService = chefListService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String loginPage(){
        return "login";
        }
        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public String welcomePage(Model model, @RequestParam String userId, @RequestParam String password){
            RedirectView redirectView = new RedirectView();
        if(!password.isEmpty() && !userId.isEmpty() && isNumeric(userId)){
            boolean theChef = this.chefListService.checkLogin(Long.parseLong(userId), password);
            String chefName = "";
            if(theChef){
                chefName = chefListService.returnName(2L);
                model.addAttribute("theChef", chefName);
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
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(){
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCheckPage(){

        return "register";
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
