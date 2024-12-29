package com.example.creditsimulator.validator;

import com.example.creditsimulator.service.Creditable;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class CreditValidator implements ConstraintValidator<KnownCredit, String> {
    private final Map<String, Creditable> credits;
    @Override
    public boolean isValid(String credit, ConstraintValidatorContext constraintValidatorContext) {
        return credits.containsKey(credit);
    }
}