package main.com.myApp.validation;


import main.com.myApp.model.Employee;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator
        implements ConstraintValidator<PasswordMatch, Employee> {

    @Override
    public boolean isValid(Employee emp, ConstraintValidatorContext context) {
        if (emp.getPassword() == null || emp.getRepassword() == null) {
            return true;
        }

        return emp.getPassword().equals(emp.getRepassword());
    }
}