package edu.uniupo.pissir.exception;

import edu.uniupo.pissir.error.ApplicationStatusError;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Getter
@Setter
public class InvalidModelException extends Exception {

    private final ApplicationStatusError status = ApplicationStatusError.BAD_REQUEST;
    private Collection<String> messages;

    public InvalidModelException ( String className, String methodName, Collection<String> messages ) {
        super( String.join( " | ", messages ) );
        Logger logger = LoggerFactory.getLogger( InvalidModelException.class );
        logger.info( "InvalidModelException is throwing by %s class in method %s ...".formatted( className, methodName ) );
        this.messages = messages;
    }
}
