package main.com.myApp.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Setter
@Getter

public class UserModel {
    private String userName;
    private String password;
    private String country;
    private String programLang;
    private List<String> operationSystem;

}