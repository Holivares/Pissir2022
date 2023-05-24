package edu.uniupo.pissir.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ModelValidator {
    private final static Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> Set<String> validate ( T candidateToValidation ) {
        Set<ConstraintViolation<T>> violations = VALIDATOR.validate( candidateToValidation );
        if( !violations.isEmpty() ) {
            return violations.stream().map( ConstraintViolation::getMessage ).collect( Collectors.toSet() );
        }

        return Collections.emptySet();
    }
}
