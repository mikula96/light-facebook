package com.consulteer.facebook.customAnnotation;

import com.consulteer.facebook.customAnnotation.annotationImpl.IsValidValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Milos Stambolija on 16.8.2019.
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsValidValidator.class)
public @interface IsValid {

    String message() default "IP address is invalid!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
