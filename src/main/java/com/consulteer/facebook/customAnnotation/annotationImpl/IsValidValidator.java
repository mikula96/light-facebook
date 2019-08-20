package com.consulteer.facebook.customAnnotation.annotationImpl;

import com.consulteer.facebook.customAnnotation.IsValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Milos Stambolija on 16.8.2019.
 **/
public class IsValidValidator implements ConstraintValidator<IsValid, String> {



    @Override
    public void initialize(IsValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        int parts = s.split(".").length;
        return true;
    }
}
