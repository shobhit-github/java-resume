package com.personal.javaresume.utilities.validators;

import com.personal.javaresume.dao.PersonalDetailRepository;
import com.personal.javaresume.utilities.annotations.UniqueEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailConstraintValidator implements ConstraintValidator<UniqueEmail, String> {

    private final PersonalDetailRepository personalDetailRepository;



    @Override
    public boolean isValid(String target, ConstraintValidatorContext constraintValidatorContext) {

        boolean isExist = false;

        try {
            isExist = this.personalDetailRepository.existsByEmail(target);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return !isExist;
    }

    public UniqueEmailConstraintValidator(PersonalDetailRepository personalDetailRepository) {
        this.personalDetailRepository = personalDetailRepository;
    }
}
