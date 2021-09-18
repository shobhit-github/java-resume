package com.personal.javaresume.utilities.annotations;


import com.personal.javaresume.utilities.validators.UniquePhoneConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniquePhoneConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface UniquePhone {

    public String message() default "There is already user with this phone number!";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};

}

