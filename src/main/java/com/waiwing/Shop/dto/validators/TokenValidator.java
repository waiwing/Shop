package com.waiwing.Shop.dto.validators;

import com.waiwing.Shop.dto.PersonDTO;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokenValidator implements ConstraintValidator<TokenPassword, String> {
    private int min;
    private int max;


    @Override
    public void initialize(TokenPassword constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s)) {
            return true;
        }

        return s.length() >= this.min && s.length() <= this.max;
    }
}
