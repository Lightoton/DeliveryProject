package de.telran.deliveryproject.validation.impl;

import de.telran.deliveryproject.validation.annotation.UuidChecker;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class UuidConstraint implements ConstraintValidator<UuidChecker, String> {
    private static final String UUID = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    @Override
    public void initialize(UuidChecker constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Optional.ofNullable(value)
                .filter(el -> !el.isBlank())
                .map(el -> el.matches(UUID))
                .orElse(false);
    }
}
