package main.com.myApp.controller;

import main.com.myApp.dao.DatabaseOperations;
import main.com.myApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class EmployeeController {

    @Autowired
    private DatabaseOperations databaseOperations;
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/registerForm")
    public String registerForm(Model model) {
        model.addAttribute("employeeModel", new Employee());
        return "Register_Form";
    }

    @RequestMapping("/success")
    public String success(@Valid @ModelAttribute("employeeModel") Employee employee, BindingResult bindingResult,
        Model model) {
            if (bindingResult.hasErrors()) {
                return "Register_Form";}


        try {databaseOperations.register(employee);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("successMessage", "Data submitted successfully");



        model.addAttribute("employeeModel", employee);

        return "Result";




    }
}

