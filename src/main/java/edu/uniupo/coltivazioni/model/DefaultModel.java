package edu.uniupo.coltivazioni.model;

import edu.uniupo.coltivazioni.exception.InvalidModelException;
import edu.uniupo.coltivazioni.service.thrower.ServiceThrower;
import edu.uniupo.coltivazioni.validator.ModelValidator;

import java.util.List;
import java.util.Set;

import static edu.uniupo.coltivazioni.service.UtenteService.serviceThrower;

public interface DefaultModel {

    static <T extends DefaultModel> void isNull ( T t, ServiceThrower<Exception> serviceThrower, String className, String methodName ) throws Exception {
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

    static <T extends DefaultModel> void checkModelType ( T t, String className, String methodeName ) throws Exception {
        T.isNull( t, serviceThrower, className, methodeName );
        t.validate( serviceThrower, className, methodeName );
    }

}
