package main.com.myApp.controller;


import main.com.myApp.models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserFormController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "userProfile/Register_Form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("userModel") UserModel userModel, Model model) {model.addAttribute("userModel", userModel);

        return "userProfile/Result";
    }

}
