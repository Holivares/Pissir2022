package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTOAttuatore;
import edu.uniupo.coltivazioni.dto.DTOAziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.services.AttuatoreServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/attuatori" )
public class AttuatoreController {

    private static final Logger logger = LoggerFactory.getLogger( AziendaAgricolaController.class );
    private final AttuatoreServices attuatoreServices;

    @Autowired
    public AttuatoreController ( AttuatoreServices attuatoreServices ) {
        this.attuatoreServices = attuatoreServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOAttuatore getAttuatore ( @PathVariable Long id ) {
        logger.info( "A call to controller getAttuatore was intercepted by him" );
        return attuatoreServices.getAttuatore( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOAttuatore createAttuatore ( @RequestBody DTOAttuatore dtoAttuatore ) {
        logger.info( "A call to controller createAttuatore was intercepted by him" );
        return attuatoreServices.saveAttuatore( dtoAttuatore );
    }

    @PatchMapping( produces = "application/json" )
    public DTOAttuatore updateAttuatore ( @RequestBody DTOAttuatore dtoAttuatore ) {
        logger.info( "A call to controller updateAziendaAgricola was intercepted by him" );
        return attuatoreServices.updateAttuatore( dtoAttuatore );
    }

    @DeleteMapping( value = "/{id}", produces = "application/json" )
    public DTODeletedResponse deleteAttuatore ( @PathVariable Long id ) {
        logger.info( "A call to controller deleteAttuatore was intercepted by him" );
        return attuatoreServices.deleteAttuatore( id );
    }
}
