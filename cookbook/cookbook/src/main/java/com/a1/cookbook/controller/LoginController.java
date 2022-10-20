package com.a1.cookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String loginPage(){
        return "login";
        }
        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public String welcomePage(ModelMap modelMap, @RequestParam String userId, @RequestParam String password){
        if(userId.equals("admin") && password.equals("thepassword")){
            modelMap.addAttribute("userID", userId);
            return "welcome";
        }
            return "login";
        }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(){
        return "login";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(){
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCheckPage(){

        return "register";
    }
}