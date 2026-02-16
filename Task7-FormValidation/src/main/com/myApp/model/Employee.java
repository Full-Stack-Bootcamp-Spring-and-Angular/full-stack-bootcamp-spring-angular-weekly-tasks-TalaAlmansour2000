package main.com.myApp.model;

import lombok.Getter;
import lombok.Setter;
import main.com.myApp.validation.PasswordMatch;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@PasswordMatch
public class Employee {
    @NotBlank(message = "this field cannot be empty")
    @Size(min = 2, message = "Name must be at least 2 characters")
    private String name;

    //    @Email
//
    @NotBlank(message = "this field cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z.-]+\\.[a-zA-Z]{2,}$", message = "please enter a valid  adress")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    private String confirmedPassword;
}
