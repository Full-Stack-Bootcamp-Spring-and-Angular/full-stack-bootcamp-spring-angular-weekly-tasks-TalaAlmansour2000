package com.task5.agecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class Age {

    @RequestMapping("/ageForm")
    public String showAgeForm()
    {
        return "ageCalculator/Age_Form";
    }


    @RequestMapping("/calculateAge")
    public String calculateAge(@RequestParam("day") int day,@RequestParam("month") int month,@RequestParam("year") int year, Model model)

    {

        int age = computeAge(year, month, day);

        model.addAttribute("userAge" ,age);

 return "ageCalculator/Age_Result";
    }
    private int computeAge(int year,int month,int day){
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        java.time.Period period = java.time.Period.between(birthDate, today);
        return period.getYears();
    }
}