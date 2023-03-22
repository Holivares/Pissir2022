package edu.uniupo.coltivazioni.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidationConstraint implements ConstraintValidator<EnumValidation, String> {
    private List<String> enumValues;

    @Override
    public void initialize ( EnumValidation enumValidation ) {
        this.enumValues = Stream.of( enumValidation.clazz().getEnumConstants() ).map( Object::toString ).collect( Collectors.toList() );
    }

    @Override
    public boolean isValid ( String value, ConstraintValidatorContext context ) {
        if( value.isBlank() ) {
            return false;
        }
        return enumValues.contains( value );
    }
}
