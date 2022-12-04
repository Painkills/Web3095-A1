package com.a1.cookbook.web;

import com.a1.cookbook.service.ChefService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
    public final ChefService chefService;
    static String chefEmail = "";
    static String chefName = "";
    static String chefLastName = "";
    static Long theChefID = 0L;

    public ProfileController(ChefService chefService) {
        this.chefService = chefService;
    }

    @RequestMapping(value = "/profile", method= RequestMethod.GET)
    public String getProfile(@RequestParam(value = "chef")Long chef, Model model){

        chefEmail = chefService.returnEmail(chef);
        chefName = chefService.returnName(chefEmail);
        chefLastName = chefService.returnLastName(chefEmail);
        theChefID = chefService.returnId(chefEmail);
        model.addAttribute("email", chefEmail);
        model.addAttribute("fName", chefName);
        model.addAttribute("lName", chefLastName);
        model.addAttribute("pass", chefLastName);
        model.addAttribute("chefId", theChefID);
        return "/profile";
    }
    @RequestMapping(value = "/profile/edit", method= RequestMethod.GET)
    public String editProfile(Model model){
        model.addAttribute("email", chefEmail);
        model.addAttribute("fName", chefName);
        model.addAttribute("lName", chefLastName);
        model.addAttribute("chefId", theChefID);
        return "/editProfile";
    }
    @RequestMapping(value = "/profile/edit", method= RequestMethod.POST)
    public String successProfileChange(Model model, @RequestParam String email, String firstName, String lastName){
        System.out.println("email: " + email + " name: " + firstName + " lastname: " + lastName + " damn" + theChefID);
        if(this.chefService.updateChef(theChefID, email, firstName, lastName)){
            return "redirect:/logout";
        }
        else{
            return "/editProfile";
        }



    }


}
