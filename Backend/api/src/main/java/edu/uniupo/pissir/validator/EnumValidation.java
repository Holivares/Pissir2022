package edu.uniupo.pissir.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target( { ElementType.PARAMETER, ElementType.FIELD } )
@Retention( RetentionPolicy.RUNTIME )
@Constraint( validatedBy = EnumValidationConstraint.class )
@Documented
public @interface EnumValidation {
    String message () default "value of field is not valid !";

    Class<?> clazz ();

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
