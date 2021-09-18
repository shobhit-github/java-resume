package com.personal.javaresume.utilities.validators;

import com.personal.javaresume.dao.PersonalDetailRepository;
import com.personal.javaresume.utilities.annotations.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameConstraintValidator implements ConstraintValidator<UniqueUsername, String> {

    private final PersonalDetailRepository personalDetailRepository;



    @Override
    public boolean isValid(String target, ConstraintValidatorContext constraintValidatorContext) {

        boolean isExist = false;

        try {
            isExist = this.personalDetailRepository.existsByUsername(target);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return !isExist;
    }

    public UniqueUsernameConstraintValidator(PersonalDetailRepository personalDetailRepository) {
        this.personalDetailRepository = personalDetailRepository;
    }
}
