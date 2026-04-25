package com.task5.userprofile.controller;

import com.task5.userprofile.dao.DatabaseOperations;
import com.task5.userprofile.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class Register {

    @Autowired
    private DatabaseOperations databaseOperations;

    @RequestMapping("/registerForm")
    public String showFormRegister(Model model){

        model.addAttribute("user", new User());
        return ("userProfile/Register_Form");
    }

    //
    @RequestMapping("/success")

    public String getData(
            @ModelAttribute("user") User user, Model model) throws Exception {


        databaseOperations.register(user);
        //java.sql.Date birthDate = java.sql.Date.valueOf(dateofb);

        model.addAttribute("user", user);
        model.addAttribute("successMessage", "Data submitted successfully");

        return "userProfile/Success_Register";
    }

}
