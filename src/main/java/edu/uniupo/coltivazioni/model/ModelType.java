package edu.uniupo.coltivazioni.model;

import edu.uniupo.coltivazioni.exception.InvalidModelException;
import edu.uniupo.coltivazioni.service.thrower.ServiceThrower;
import edu.uniupo.coltivazioni.validator.ModelValidator;

import java.util.List;
import java.util.Set;

public interface ModelType {

    static <T extends ModelType> void isNull ( T t, ServiceThrower<Exception> serviceThrower, String className, String methodName ) throws Exception {
        if( t == null ) {
            serviceThrower.thrower( new InvalidModelException( className, methodName, List.of( "The data you sent is not valid, please check your data" ) ) );
        }
    }

    default void validate ( ServiceThrower<Exception> serviceThrower, String className, String methodName ) throws Exception {
        Set<String> constraints = ModelValidator.validate( this );
        if( !constraints.isEmpty() ) {
            serviceThrower.thrower( new InvalidModelException( className, methodName, constraints ) );
        }
    }
}
