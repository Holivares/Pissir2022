package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOMisura;
import edu.uniupo.coltivazioni.dto.DTOProgrammaIrrig;
import edu.uniupo.coltivazioni.services.ProgrammaIrrigServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/programma_irrig" )
public class ProgrammaIrrigController {

    private static final Logger logger = LoggerFactory.getLogger( AziendaAgricolaController.class );
    private final ProgrammaIrrigServices programmaIrrigServices;

    @Autowired
    public ProgrammaIrrigController ( ProgrammaIrrigServices programmaIrrigServices ) {
        this.programmaIrrigServices = programmaIrrigServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOProgrammaIrrig getProgrammaIrrig ( @PathVariable Long id ) {
        logger.info( "A call to controller getProgrammaIrrig was intercepted by him" );
        return programmaIrrigServices.geProgrammaIrrig( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOProgrammaIrrig createProgramma ( @RequestBody DTOProgrammaIrrig dtoProgrammaIrrig ) {
        logger.info( "A call to controller createProgramma was intercepted by him" );
        return programmaIrrigServices.saveProgramma( dtoProgrammaIrrig );
    }

    @PatchMapping( produces = "application/json" )
    public DTOProgrammaIrrig updateProgramma ( @RequestBody DTOProgrammaIrrig dtoProgrammaIrrig ) {
        logger.info( "A call to controller updateProgramma was intercepted by him" );
        return programmaIrrigServices.updateProgramma( dtoProgrammaIrrig );
    }

    @DeleteMapping( value = "/{id}", produces = "application/json" )
    public DTODeletedResponse deleteProgramma ( @PathVariable Long id ) {
        logger.info( "A call to controller deleteProgramma was intercepted by him" );
        return programmaIrrigServices.deleteProgramma( id );
    }
}
