package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOSerra;
import edu.uniupo.coltivazioni.services.SerraServices;
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
@RequestMapping( value = "v1/serre" )
public class SerraController {

    private final SerraServices serraServices;
    private final Logger logger = LoggerFactory.getLogger( SensoreController.class );

    @Autowired
    public SerraController ( SerraServices serraServices ) {
        this.serraServices = serraServices;
    }

    @PostMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.CREATED )
    public DTOSerra createSerra ( @RequestBody DTOSerra dtoSerra ) {
        logger.info( "i'm in the to create an serra" );
        return serraServices.createSerra( dtoSerra );
    }

    @PutMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public DTOSerra updateSerra ( @RequestBody DTOSerra dtoSerra ) {
        logger.info( "i'm in the to update an serra" );
        return serraServices.updateSerra( dtoSerra );
    }

    @DeleteMapping( value = "/{idSerra}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public DTODeleteResponse deleteSerra ( @PathVariable UUID idSerra ) {
        logger.info( "i'm in the controller to delete an serra" );
        return serraServices.deleteSerra( idSerra );
    }

    @GetMapping( value = "/{idAziendaAgricola}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public DTOSerra findSerraByIdAziendaAgricola ( @PathVariable UUID idAziendaAgricola ) {
        logger.info( "i'm in the controller to find an serra by idAziendaAgricola" );
        return serraServices.findSerraByIdAziendaAgricola( idAziendaAgricola );
    }

}


