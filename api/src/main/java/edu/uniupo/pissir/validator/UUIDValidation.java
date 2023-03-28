package edu.uniupo.pissir.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target( value = { ElementType.FIELD, ElementType.PARAMETER } )
@Retention( RetentionPolicy.RUNTIME )
@Documented
@Constraint( validatedBy = UUIValidationConstraint.class )
public @interface UUIDValidation {
    String message () default "value of field is not valid !";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
