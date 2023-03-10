package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOMisura;
import edu.uniupo.coltivazioni.services.MisuraServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/misure" )
public class MisuraController {

    private static final Logger logger = LoggerFactory.getLogger( AziendaAgricolaController.class );
    private final MisuraServices misuraServices;

    @Autowired
    public MisuraController ( MisuraServices misuraServices ) {
        this.misuraServices = misuraServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOMisura getMisura ( @PathVariable Long id ) {
        logger.info( "A call to controller getMisura was intercepted by him" );
        return misuraServices.getMisura( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOMisura createMisura ( @RequestBody DTOMisura dtoMisura ) {
        logger.info( "A call to controller createMisura was intercepted by him" );
        return misuraServices.saveMisura( dtoMisura );
    }

    @PatchMapping( produces = "application/json" )
    public DTOMisura updateMisura ( @RequestBody DTOMisura dtoMisura ) {
        logger.info( "A call to controller updateMisura was intercepted by him" );
        return misuraServices.updateMisura( dtoMisura );
    }

    @DeleteMapping( value = "/{id}", produces = "application/json" )
    public DTODeletedResponse deleteMisura ( @PathVariable Long id ) {
        logger.info( "A call to controller deleteMisura was intercepted by him" );
        return misuraServices.deleteMisura( id );
    }
}
