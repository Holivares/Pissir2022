package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.model.AziendaAgricolaModel;
import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.service.AziendaAgricolaService;
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
    public AziendaAgricolaModel createAziendaAgricola ( @RequestBody AziendaAgricolaModel aziendaAgricolaModel ) {
        logger.info( "i'm in the controller to create an azienda agricola ..." );
        return aziendaAgricolaService.createAziendaAgricola( aziendaAgricolaModel );
    }

    @PutMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public AziendaAgricolaModel updateAziendaAgricola ( @RequestBody AziendaAgricolaModel aziendaAgricolaModel ) {
        logger.info( "i'm in the controller to update an azienda agricola ..." );
        return aziendaAgricolaService.updateAziendaAgricola( aziendaAgricolaModel );
    }

    @DeleteMapping( value = "/{idAziendaAgricola}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public DeleteResponseModel deleteAziendaAgricola ( @PathVariable UUID idAziendaAgricola ) {
        logger.info( "i'm in the controller to delete an azienda agricola ..." );
        return aziendaAgricolaService.deleteAziendaAgricola( idAziendaAgricola );
    }

    @GetMapping( value = "/{idUtente}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public AziendaAgricolaModel findAziendaAgricolaByIdUser ( @PathVariable UUID idUtente ) {
        logger.info( "i'm in the controller to find an azienda agricola by User id ..." );
        return aziendaAgricolaService.findAziendaAgricolaByIdUser( idUtente );
    }

    @GetMapping( value = "/{idAziendaAgricola}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public AziendaAgricolaModel findAziendaAgricolaById ( @PathVariable UUID idAziendaAgricola ) {
        logger.info( "i'm in the controller to find an azienda agricola by AziendaAgricola id ..." );
        return aziendaAgricolaService.findAziendaAgricolaById( idAziendaAgricola );
    }

    @GetMapping( value = "/{nome}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public AziendaAgricolaModel findAziendaAgricolaByName ( @PathVariable String nome ) {
        logger.info( "i'm in the controller to find an azienda agricola by name ..." );
        return aziendaAgricolaService.findAziendaAgricolaByName( nome );
    }
}
