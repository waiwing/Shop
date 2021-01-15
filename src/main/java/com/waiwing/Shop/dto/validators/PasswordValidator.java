package com.waiwing.Shop.dto.validators;

import com.waiwing.Shop.dto.PersonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordEqual, PersonDTO> {
    private  int min;
    private  int max;
    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(PersonDTO personDTO, ConstraintValidatorContext constraintValidatorContext) {
        String pwd1 = personDTO.getPassword1();
        String pwd2 = personDTO.getPassword2();
        boolean match = pwd1.equals(pwd2);
        return match;
    }
}
