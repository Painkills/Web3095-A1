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

import java.util.Objects;

@Controller
public class LoginController {
    public final ChefService chefService;
    static private String theChefEmail = "";
    public LoginController(ChefService chefService) {
        this.chefService = chefService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        if(!Objects.equals(theChefEmail, "")) {
            return "redirect:/welcome";
        }
        else{
            return "login";
        }
    }
    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public String resetPasswordPage(){
        return "loginToReset";
    }
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String forgotPasswordPage(){
        return "forgotPassword";
    }
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public String resetPassword(Model model, @RequestParam String email, String password, String newPassword){
        boolean passUpdated = this.chefService.updatePassword(email, password, newPassword);
        System.out.println(passUpdated);
        if(passUpdated){
            return "redirect:/login";
        }else{
            model.addAttribute("wrongLabel", "Email or Password is incorrect");
            return "loginToReset";
        }
    }
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public String forgotPassword(Model model, @RequestParam String email, String name, String newPassword){
        boolean passUpdated = this.chefService.forgotPassword(email, name, newPassword);
        System.out.println(passUpdated);
        if(passUpdated){
            return "redirect:/login";
        }else{
            model.addAttribute("wrongLabel", "Email or Name is incorrect");
            return "forgotPassword";
        }
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
                theChefEmail = email;
                chefName = chefService.returnName(email);
                chefId = chefService.returnId(email);
                model.addAttribute("theChef", chefName);
                model.addAttribute("chefId", chefId);
                return "redirect:/welcome";
            }else{
                return "login";
            }
        }else{
            return "login";

        }
    }

    @RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
    public String welcomePageParam(String chefName) {
        return "welcome";
    }
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomePage(Model model) {
        if(!Objects.equals(theChefEmail, "")) {
            String chefName = "";
            Long chefId;
            chefName = chefService.returnName(theChefEmail);
            chefId = chefService.returnId(theChefEmail);
            model.addAttribute("theChef", chefName);
            model.addAttribute("chefId", chefId);
            return "welcome";
        }
        else{
            return "redirect:/login";
        }
    }
    @RequestMapping(value = "/logout")
    public String LogoutPage(){
        theChefEmail = "";
        return "redirect:/login";
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
