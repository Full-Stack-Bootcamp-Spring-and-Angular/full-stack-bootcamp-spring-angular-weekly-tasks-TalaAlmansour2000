package com.task5.userprofile.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private String firstName;
    private  String lastName;
    private  String  email ;
    private LocalDate date;
    private String city;


}
