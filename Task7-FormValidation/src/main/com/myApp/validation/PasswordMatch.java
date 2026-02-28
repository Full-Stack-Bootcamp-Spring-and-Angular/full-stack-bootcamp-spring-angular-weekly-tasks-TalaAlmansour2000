package main.com.myApp.validation;

import main.com.myApp.validation.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented


@Constraint(validatedBy = PasswordValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatch {
//
    String message() default "The password fields must match";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
