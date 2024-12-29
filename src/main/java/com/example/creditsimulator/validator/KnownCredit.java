package com.example.creditsimulator.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {CreditValidator.class})
@Target(FIELD)
@Retention(RUNTIME)
public @interface KnownCredit {
    String message() default "Unknown credit type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}