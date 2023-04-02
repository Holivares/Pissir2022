package edu.uniupo.pissir.controller;

import edu.uniupo.pissir.model.AttuatoreModel;
import edu.uniupo.pissir.service.AttuatoreService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( "v1/attuatori" )
public class AttuatoreController {

    private final AttuatoreService attuatoreService;
    private final Logger logger = LoggerFactory.getLogger( AttuatoreController.class );

    @Autowired
    public AttuatoreController ( AttuatoreService attuatoreService ) {
        this.attuatoreService = attuatoreService;
    }

    @PostMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.CREATED )
    public AttuatoreModel createAttuatore ( HttpSession session, @RequestBody AttuatoreModel attuatoreModel ) throws Exception {
        logger.info( "i'm in the controller to create an Attuatore ..." );
        return attuatoreService.createAttuatore( session, attuatoreModel );

    }

    @GetMapping( value = "/{idSerra}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public List<AttuatoreModel> findAttuatoreBySerra ( HttpSession session, @PathVariable UUID idSerra ) throws Exception {
        logger.info( "i'm in the controller to find an attuatore by Serra id ..." );
        return attuatoreService.findAttuatoreByIdSerra( session, idSerra );
    }

    @GetMapping( value = "/enable/{idAttuatore}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public AttuatoreModel enableAttuatore ( HttpSession session, @PathVariable UUID idAttuatore ) throws Exception {
        logger.info( "i'm in the controller to enable an attuatore ..." );
        return attuatoreService.enableAttuatore( session, idAttuatore );
    }

    @GetMapping( value = "/disable/{idAttuatore}", produces = "application/json" )
    @ResponseStatus( HttpStatus.OK )
    public AttuatoreModel disableAttuatore ( HttpSession session, @PathVariable UUID idAttuatore ) throws Exception {
        logger.info( "i'm in he controller to disable an attuatore ..." );
        return attuatoreService.disableAttuatore( session, idAttuatore );
    }

}
