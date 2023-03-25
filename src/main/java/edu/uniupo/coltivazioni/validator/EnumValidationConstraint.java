package edu.uniupo.coltivazioni.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class EnumValidationConstraint implements ConstraintValidator<EnumValidation, Object> {
    private List<String> enumValues;

    @Override
    public void initialize ( EnumValidation enumValidation ) {
        this.enumValues = Stream.of( enumValidation.clazz().getEnumConstants() ).map( Object::toString ).collect( Collectors.toList() );
    }

    @Override
    public boolean isValid ( Object value, ConstraintValidatorContext context ) {
        if( value == null ) {
            return false;
        } else {
            return enumValues.contains( value.getClass().cast( value ).toString() );
        }
    }
}
