package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOSerra;
import edu.uniupo.coltivazioni.services.SerraServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/serra" )
public class SerraController {

    private static final Logger logger = LoggerFactory.getLogger( AziendaAgricolaController.class );
    private final SerraServices serraServices;

    public SerraController ( SerraServices serraServices ) {
        this.serraServices = serraServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOSerra getSerra ( @PathVariable Long id ) {
        logger.info( "A call to controller getSerra was intercepted by him" );
        return serraServices.getSerra( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOSerra createSerra ( @RequestBody DTOSerra dtoSerra ) {
        logger.info( "A call to controller createSerra was intercepted by him" );
        return serraServices.saveSerra( dtoSerra );
    }

    @PatchMapping( produces = "application/json" )
    public DTOSerra updateSerra ( @RequestBody DTOSerra dtoSerra ) {
        logger.info( "A call to controller updateSerra was intercepted by him" );
        return serraServices.updateSerra( dtoSerra );
    }

    @DeleteMapping( value = "/{id}", produces = "application/json" )
    public DTODeletedResponse deletedSerra ( @PathVariable Long id ) {
        logger.info( "A call to controller deletedSerra was intercepted by him" );
        return serraServices.deleteSerra( id );
    }
}
