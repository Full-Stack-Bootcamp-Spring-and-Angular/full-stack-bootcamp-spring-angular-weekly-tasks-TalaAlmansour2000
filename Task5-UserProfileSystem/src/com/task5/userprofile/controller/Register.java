package com.task5.userprofile.controller;

import com.task5.userprofile.dao.DatabaseOperations;
import com.task5.userprofile.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller

public class Register {

    @Autowired
    private DatabaseOperations databaseOperations;

    @RequestMapping("/registerForm")
    public String showFormRegister(){
        return ("userProfile/Register_Form");
    }

    //
    @RequestMapping("/success")

    public String getData(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("date") String dateofb, @RequestParam("city") String city ,
            Model model) throws Exception {

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setDate(LocalDate.parse(dateofb));
        user.setCity(city);

        databaseOperations.register(user);
        //java.sql.Date birthDate = java.sql.Date.valueOf(dateofb);

        model.addAttribute("user", user);
        model.addAttribute("successMessage", "Data submitted successfully");

        return "userProfile/Success_Register";
    }

}
