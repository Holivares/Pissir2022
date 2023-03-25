package edu.uniupo.coltivazioni.exception;

import edu.uniupo.coltivazioni.error.ApplicationError;
import edu.uniupo.coltivazioni.error.ApplicationStatusError;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class ApplicationHandlerException {

    private final Logger logger = LoggerFactory.getLogger( ApplicationHandlerException.class );

    @ExceptionHandler( InvalidModelException.class )
    @ResponseStatus( value = HttpStatus.BAD_REQUEST )
    public ApplicationError handleInvalidModelException ( InvalidModelException invalidModelException ) {
        logger.info( "InvalidModelException caught with messages : %s".formatted( String.join( " | ", invalidModelException.getMessages() ) ) );
        return new ApplicationError( invalidModelException.getStatus(), invalidModelException.getMessages() );
    }

    @ExceptionHandler( NotFoundEntityException.class )
    @ResponseStatus( value = HttpStatus.BAD_REQUEST )
    public ApplicationError handleNotFoundEntityException ( NotFoundEntityException notFoundEntityException ) {
        logger.info( "NotFoundEntityException caught with messages : %s".formatted( notFoundEntityException.getMessage() ) );
        return new ApplicationError( notFoundEntityException.getStatus(), List.of( notFoundEntityException.getMessage() ) );
    }

    @ExceptionHandler( DuplicateEntityException.class )
    @ResponseStatus( value = HttpStatus.BAD_REQUEST )
    public ApplicationError handleDuplicateAziendaAgricola ( DuplicateEntityException duplicateEntityException ) {
        logger.info( "DuplicateAziendaAgricola caught with messages : %s".formatted( duplicateEntityException.getMessage() ) );
        return new ApplicationError( duplicateEntityException.getStatus(), List.of( duplicateEntityException.getMessage() ) );
    }

    @ExceptionHandler( { SQLIntegrityConstraintViolationException.class, ConstraintViolationException.class, DataIntegrityViolationException.class } )
    @ResponseStatus( value = HttpStatus.BAD_REQUEST )
    public ApplicationError handleSqlConstraintException ( SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException ) {
        logger.info( "SQLIntegrityConstraintViolationException caught with messages : %s".formatted( sqlIntegrityConstraintViolationException.getMessage() ) );
        if( sqlIntegrityConstraintViolationException.getMessage().contains( "Duplicate entry" ) ) {
            return new ApplicationError( ApplicationStatusError.BAD_REQUEST, List.of( "This email is already registered in server" ) );
        } else if( sqlIntegrityConstraintViolationException.getMessage().contains( "Cannot add or update a child row" ) ) {
            return new ApplicationError( ApplicationStatusError.BAD_REQUEST, List.of( "It's not possible to create azienda for not existing user" ) );
        }
        return new ApplicationError( ApplicationStatusError.BAD_REQUEST, List.of( "An error is caught due to your request, register has fail" ) );
    }

    @ExceptionHandler( InternalApplicationException.class )
    @ResponseStatus( value = HttpStatus.INTERNAL_SERVER_ERROR )
    public ApplicationError handleInternalApplicationException ( InternalApplicationException internalApplicationException ) {
        logger.info( "InternalApplicationException handle with messages : %s".formatted( internalApplicationException.getMessage() ) );
        return new ApplicationError( ApplicationStatusError.INTERNAL_SERVER_ERROR, List.of( "Application encountered internal error" ) );
    }

    @ExceptionHandler( Exception.class )
    @ResponseStatus( value = HttpStatus.INTERNAL_SERVER_ERROR )
    public ApplicationError handleException ( Exception exception ) {
        logger.info( "Exception handle with messages : %s".formatted( exception.getMessage() ) );
        return new ApplicationError( ApplicationStatusError.INTERNAL_SERVER_ERROR, List.of( "An internal server error is caught due to your request" ) );
    }

    @ExceptionHandler( RuntimeException.class )
    public ResponseEntity<ApplicationError> handleRuntimeException ( RuntimeException runtimeException ) {
        logger.info( "RuntimeException handle with messages : %s".formatted( runtimeException.getMessage() ) );
        if( runtimeException.getMessage().contains( "JSON parse error" ) ) {
            return new ResponseEntity<>( this.handleInvalidModelException( new InvalidModelException( this.getClass().getName(),
                                                                                                      "handleRuntimeException",
                                                                                                      List.of( "The data you sent is not valid, please check " +
                                                                                                               "your data" ) ) ), HttpStatus.BAD_REQUEST );
        }
        runtimeException.printStackTrace();
        return new ResponseEntity<>( new ApplicationError( ApplicationStatusError.INTERNAL_SERVER_ERROR,
                                                           List.of( "An internal server error is caught due to your request" ) ),
                                     HttpStatus.INTERNAL_SERVER_ERROR );
    }

}
