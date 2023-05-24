package edu.uniupo.pissir.exception;

import edu.uniupo.pissir.error.ApplicationStatusError;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class NotFoundEntityException extends Exception {
    private final ApplicationStatusError status = ApplicationStatusError.BAD_REQUEST;
    private final String message;

    public NotFoundEntityException ( String className, String methodName, String message ) {
        super( message );
        Logger logger = LoggerFactory.getLogger( NotFoundEntityException.class );
        logger.info( "NotFoundEntityException is throwing by %s class in method %s ...".formatted( className, methodName ) );
        this.message = message;
    }
}
