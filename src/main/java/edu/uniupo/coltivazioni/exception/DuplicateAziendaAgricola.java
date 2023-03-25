package edu.uniupo.coltivazioni.exception;

import edu.uniupo.coltivazioni.error.ApplicationStatusError;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class DuplicateAziendaAgricola extends Exception {
    private final ApplicationStatusError status = ApplicationStatusError.BAD_REQUEST;
    private final String message;

    public DuplicateAziendaAgricola ( String className, String methodName, String message ) {
        super( message );
        Logger logger = LoggerFactory.getLogger( DuplicateAziendaAgricola.class );
        logger.info( "DuplicateAziendaAgricola is throwing by %s class in method %s ...".formatted( className, methodName ) );
        this.message = message;
    }
}
