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
    public String welcomePage(Model model, @RequestParam String userId, String password){
        RedirectView redirectView = new RedirectView();
        if(!password.isEmpty() && !userId.isEmpty() && isNumeric(userId)){
            boolean theChef = this.chefService.checkLogin(Long.parseLong(userId), password);
            String chefName = "";
            if(theChef){
                chefName = chefService.returnName(Long.parseLong(userId));
                model.addAttribute("theChef", chefName);
                return "redirect:/welcome";
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
