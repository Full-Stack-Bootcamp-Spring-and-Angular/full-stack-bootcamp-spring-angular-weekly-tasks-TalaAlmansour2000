package main.com.myApp.validation;


import main.com.myApp.model.Employee;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator
        implements ConstraintValidator<PasswordMatch, Employee> {

    @Override
    public boolean isValid(Employee emp, ConstraintValidatorContext context) {
        if (emp.getPassword() == null || emp.getConfirmedPassword() == null) {
            return true;
        }
        boolean isValid = emp.getPassword().equals(emp.getConfirmedPassword());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password do not match")
                    .addPropertyNode("confirmedPassword")
                    .addConstraintViolation();
        }
        return isValid;
    }}