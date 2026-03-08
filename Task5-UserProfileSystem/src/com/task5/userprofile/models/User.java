package com.task5.userprofile.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String firstName;
    private  String lastName;
    private  String  email ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String city;


}
