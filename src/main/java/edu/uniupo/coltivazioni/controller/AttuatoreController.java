package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTOAttuatore;
import edu.uniupo.coltivazioni.services.AttuatoreServices;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/attuatori" )
public class AttuatoreController {

    private final AttuatoreServices attuatoreServices;
    private final Logger logger = LoggerFactory.getLogger( AttuatoreController.class );

    @Autowired
    public AttuatoreController ( AttuatoreServices attuatoreServices ) {
        this.attuatoreServices = attuatoreServices;
    }

    @PostMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.CREATED )
    public DTOAttuatore createAtrtuatore ( @RequestBody @Valid DTOAttuatore dtoAttuatore ) {
        logger.info( "i'm in the controller createAtrtuatore ..." );
        return attuatoreServices.createAttuatore( dtoAttuatore );

    }

    @GetMapping( value = "/{idSerra}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public DTOAttuatore findAttuatoreBySerra ( @PathVariable UUID idSerra ) {
        logger.info( "i'm in the controller to find an attuatore by idSerra" );
        return attuatoreServices.findAttuatoreByIdSerra( idSerra );
    }

    @GetMapping( value = "/enable/{idAttuatore}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public DTOAttuatore enableAttuatore ( @PathVariable UUID idAttuatore ) {
        logger.info( "i'm in the controller to activate an attuatore" );
        return attuatoreServices.enableAttuatore( idAttuatore );
    }

    @GetMapping( value = "/disable/{idAttuatore}", produces = "application/json" )
    @ResponseStatus( HttpStatus.OK )
    public DTOAttuatore disableAttuatore ( @PathVariable UUID idAttuatore ) {
        logger.info( "i'm in he controller to disactivate an attuatore" );
        return attuatoreServices.disableAttuatore( idAttuatore );
    }

}
