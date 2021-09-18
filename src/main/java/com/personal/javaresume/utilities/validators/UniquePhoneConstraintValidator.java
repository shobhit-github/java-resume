package com.personal.javaresume.utilities.validators;

import com.personal.javaresume.dao.PersonalDetailRepository;
import com.personal.javaresume.utilities.annotations.UniquePhone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePhoneConstraintValidator implements ConstraintValidator<UniquePhone, String> {

    private final PersonalDetailRepository personalDetailRepository;



    @Override
    public boolean isValid(String target, ConstraintValidatorContext constraintValidatorContext) {

        boolean isExist = false;

        try {
            isExist = this.personalDetailRepository.existsByPhone(target);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return !isExist;
    }

    public UniquePhoneConstraintValidator(PersonalDetailRepository personalDetailRepository) {
        this.personalDetailRepository = personalDetailRepository;
    }
}
