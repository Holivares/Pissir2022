package edu.uniupo.pissir.controller;

import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.UtenteAutenticazioneModel;
import edu.uniupo.pissir.model.UtenteModel;
import edu.uniupo.pissir.service.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping( value = "v1/utenti" )
public class UtenteController {

    private final UtenteService utenteService;
    private final Logger logger = LoggerFactory.getLogger( UtenteController.class );

    @Autowired
    public UtenteController ( UtenteService utenteService ) {
        this.utenteService = utenteService;
    }

    @PostMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.CREATED )
    public UtenteModel createUtente ( @RequestBody UtenteModel utenteModel ) throws Exception {
        logger.info( "i'm in the controller to create an utente ..." );
        return utenteService.createUtente( utenteModel );
    }

    @PutMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public UtenteModel updateUtente ( @RequestBody UtenteModel utenteModel ) throws Exception {
        logger.info( "i'm in the controller to update an utente ..." );
        return utenteService.updateUtente( utenteModel );
    }

    @DeleteMapping( value = "/{idUtente}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public DeleteResponseModel deleteUtenteById ( @PathVariable UUID idUtente ) throws Exception {
        logger.info( "i'm in the controller to delete an utente by idUtente ..." );
        return utenteService.deleteUtenteById( idUtente );
    }

    @PostMapping( value = "/utenteAutenticazione", produces = "application/json" )
    public UtenteModel findUtenteByEmailAndPassword ( @RequestBody UtenteAutenticazioneModel utenteAutenticazioneModel ) throws Exception {
        logger.info( "i'm in the controller to find utente by email and password ..." );
        return utenteService.findUtenteByEmailAndPassword( utenteAutenticazioneModel );
    }
}
