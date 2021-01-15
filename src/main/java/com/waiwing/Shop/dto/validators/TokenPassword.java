package com.waiwing.Shop.dto.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = TokenValidator.class)
public @interface TokenPassword {
    int min() default 6;

    int max() default 32;

    Class<?>[] groups() default {};
   String message() default "password are not equals";


    Class<? extends Payload>[] payload() default {};
}
