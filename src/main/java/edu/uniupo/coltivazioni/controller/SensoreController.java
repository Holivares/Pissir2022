package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOProgrammaIrrig;
import edu.uniupo.coltivazioni.dto.DTOSensore;
import edu.uniupo.coltivazioni.services.SensoreServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/sensori" )
public class SensoreController {

    private static final Logger logger = LoggerFactory.getLogger( AziendaAgricolaController.class );
    private final SensoreServices sensoreServices;

    @Autowired
    public SensoreController ( SensoreServices sensoreServices ) {
        this.sensoreServices = sensoreServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOSensore getSensore ( @PathVariable Long id ) {
        logger.info( "A call to controller getSensore was intercepted by him" );
        return sensoreServices.getSensore( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOSensore createSensore ( @RequestBody DTOSensore dtoSensore ) {
        logger.info( "A call to controller createSensore was intercepted by him" );
        return sensoreServices.saveSensore( dtoSensore );
    }

    @PatchMapping( produces = "application/json" )
    public DTOSensore updateSensore ( @RequestBody DTOSensore dtoSensore ) {
        logger.info( "A call to controller updateProgramma was intercepted by him" );
        return sensoreServices.updateSensore( dtoSensore );
    }

    @DeleteMapping( value = "/{id}", produces = "application/json" )
    public DTODeletedResponse deleteSensore ( @PathVariable Long id ) {
        logger.info( "A call to controller deleteProgramma was intercepted by him" );
        return sensoreServices.deleteSensore( id );
    }

}
