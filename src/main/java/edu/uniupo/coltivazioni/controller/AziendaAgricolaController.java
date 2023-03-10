package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTOAziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.services.AziendaAgricolaServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Evrard
 * @author
 */

@RestController
@RequestMapping( "v1/aziende" )
public class AziendaAgricolaController {

    private static final Logger logger = LoggerFactory.getLogger( AziendaAgricolaController.class );
    private final AziendaAgricolaServices aziendaAgricolaServices;

    @Autowired
    public AziendaAgricolaController ( AziendaAgricolaServices aziendaAgricolaServices ) {
        this.aziendaAgricolaServices = aziendaAgricolaServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOAziendaAgricola getAziendaAgricola ( @PathVariable Long id ) {
        logger.info( "A call to controller getAziendaAgricola was intercepted by him" );
        return aziendaAgricolaServices.getAziendaAgricola( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOAziendaAgricola createAziendaAgricola ( @RequestBody DTOAziendaAgricola dtoAziendaAgricola ) {
        logger.info( "A call to controller createAziendaAgricola was intercepted by him");
        return aziendaAgricolaServices.saveAzienda( dtoAziendaAgricola );
    }

    @PatchMapping( produces = "application/json" )
    public DTOAziendaAgricola updateAziendaAgricola ( @RequestBody DTOAziendaAgricola dtoAziendaAgricola ) {
        logger.info( "A call to controller updateAziendaAgricola was intercepted by him" );
        return aziendaAgricolaServices.updateAzienda( dtoAziendaAgricola );
    }

    @DeleteMapping( value = "/{id}", produces = "application/json" )
    public DTODeletedResponse deleteAziendaAricola ( @PathVariable Long id ) {
        logger.info( "A call to controller deleteAziendaAricola was intercepted by him" );
        return aziendaAgricolaServices.deleteAzienda( id );
    }
}

