package edu.uniupo.pissir.controller;

import edu.uniupo.pissir.model.AziendaAgricolaModel;
import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.service.AziendaAgricolaService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping( "v1/aziende" )
public class AziendaAgricolaController {
    private final AziendaAgricolaService aziendaAgricolaService;
    private final Logger logger = LoggerFactory.getLogger( AziendaAgricolaController.class );

    @Autowired
    public AziendaAgricolaController ( AziendaAgricolaService aziendaAgricolaService ) {
        this.aziendaAgricolaService = aziendaAgricolaService;
    }

    @PostMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.CREATED )
    public AziendaAgricolaModel createAziendaAgricola ( HttpSession session, @RequestBody AziendaAgricolaModel aziendaAgricolaModel ) throws Exception {
        logger.info( "i'm in the controller to create an azienda agricola ..." );
        return aziendaAgricolaService.createAziendaAgricola( session, aziendaAgricolaModel );
    }

    @PutMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public AziendaAgricolaModel updateAziendaAgricola ( HttpSession session, @RequestBody AziendaAgricolaModel aziendaAgricolaModel ) throws Exception {
        logger.info( "i'm in the controller to update an azienda agricola ..." );
        return aziendaAgricolaService.updateAziendaAgricola( session, aziendaAgricolaModel );
    }

    @DeleteMapping( value = "/{idAziendaAgricola}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public DeleteResponseModel deleteAziendaAgricola ( HttpSession session, @PathVariable UUID idAziendaAgricola ) throws Exception {
        logger.info( "i'm in the controller to delete an azienda agricola ..." );
        return aziendaAgricolaService.deleteAziendaAgricola( session, idAziendaAgricola );
    }

    @GetMapping( value = "/by_utente/{idUtente}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public AziendaAgricolaModel findAziendaAgricolaByIdUser ( HttpSession session, @PathVariable UUID idUtente ) throws Exception {
        logger.info( "i'm in the controller to find an azienda agricola by User id ..." );
        return aziendaAgricolaService.findAziendaAgricolaByIdUser( session, idUtente );
    }

    @GetMapping( value = "/by_identifiant/{idAziendaAgricola}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public AziendaAgricolaModel findAziendaAgricolaById ( HttpSession session, @PathVariable UUID idAziendaAgricola ) throws Exception {
        logger.info( "i'm in the controller to find an azienda agricola by AziendaAgricola id ..." );
        return aziendaAgricolaService.findAziendaAgricolaById( session, idAziendaAgricola );
    }

    @GetMapping( value = "/by_name/{nome}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public AziendaAgricolaModel findAziendaAgricolaByName ( HttpSession session, @PathVariable String nome ) throws Exception {
        logger.info( "i'm in the controller to find an azienda agricola by name ..." );
        return aziendaAgricolaService.findAziendaAgricolaByName( session, nome );
    }
}
