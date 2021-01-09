package com.waiwing.Shop.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordEqual {
    int min() default 4;

    int max() default 6;


    String message() default "password are not equals";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
