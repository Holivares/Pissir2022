package edu.uniupo.coltivazioni.validator;

import edu.uniupo.coltivazioni.utility.RegexPattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.UUID;

public class UUIValidationConstraint implements ConstraintValidator<UUIDValidation, UUID> {

    @Override
    public void initialize ( UUIDValidation constraintAnnotation ) {
        ConstraintValidator.super.initialize( constraintAnnotation );
    }

    @Override
    public boolean isValid ( UUID value, ConstraintValidatorContext context ) {
        System.out.println( "****Validation of UUID value = " + value.getClass() );
        return RegexPattern.UUID_REGEX.matcher( value.toString() ).matches();
    }
}
