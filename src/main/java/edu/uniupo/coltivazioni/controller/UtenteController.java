package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOSerra;
import edu.uniupo.coltivazioni.dto.DTOUtente;
import edu.uniupo.coltivazioni.services.UtenteServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/utente" )
public class UtenteController {

    private static final Logger logger = LoggerFactory.getLogger( AziendaAgricolaController.class );
    private final UtenteServices utenteServices;

    @Autowired
    public UtenteController ( UtenteServices utenteServices ) {
        this.utenteServices = utenteServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOUtente getUtente ( @PathVariable Long id ) {
        logger.info( "A call to controller getUtente was intercepted by him" );
        return utenteServices.getUtente( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOUtente createUtente ( @RequestBody DTOUtente dtoUtente ) {
        logger.info( "A call to controller createUtente was intercepted by him" );
        return utenteServices.saveUtente( dtoUtente );
    }

    @PatchMapping( produces = "application/json" )
    public DTOUtente updateUtente ( @RequestBody DTOUtente dtoUtente ) {
        logger.info( "A call to controller updateUtente was intercepted by him" );
        return utenteServices.updateUtente( dtoUtente );
    }

    @DeleteMapping( value = "/{id}", produces = "application/json" )
    public DTODeletedResponse deletedUtente ( @PathVariable Long id ) {
        logger.info( "A call to controller deletedUtente was intercepted by him" );
        return utenteServices.deleteUtente( id );
    }
}
