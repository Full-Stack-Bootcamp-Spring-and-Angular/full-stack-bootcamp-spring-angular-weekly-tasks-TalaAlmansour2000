package main.com.myApp.controller;


import main.com.myApp.dao.DatabaseOperations;
import main.com.myApp.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class UserFormController {
    @Autowired
    private DatabaseOperations userDAO;

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "userProfile/Register_Form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("userModel") UserModel userModel, Model model) throws SQLException {
        userDAO.save(userModel);
        model.addAttribute("userModel", userModel);
        model.addAttribute("successMessage", "User saved in database!");
        return "userProfile/Result";
    }

}
