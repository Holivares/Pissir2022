package edu.uniupo.pissir.controller;

import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.SerraModel;
import edu.uniupo.pissir.service.SerraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( value = "v1/serre" )
public class SerraController {

    private final SerraService serraService;
    private final Logger logger = LoggerFactory.getLogger( SensoreController.class );

    @Autowired
    public SerraController ( SerraService serraService ) {
        this.serraService = serraService;
    }

    @PostMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.CREATED )
    public SerraModel createSerra ( @RequestBody SerraModel serraModel ) throws Exception {
        logger.info( "i'm in the controller to create an serra ..." );
        return serraService.createSerra( serraModel );
    }

    @PutMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public SerraModel updateSerra ( @RequestBody SerraModel serraModel ) throws Exception {
        logger.info( "i'm in the controller to update an serra ..." );
        return serraService.updateSerra( serraModel );
    }

    @DeleteMapping( value = "/{idSerra}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public DeleteResponseModel deleteSerra ( @PathVariable UUID idSerra ) throws Exception {
        logger.info( "i'm in the controller to delete an serra ..." );
        return serraService.deleteSerra( idSerra );
    }

    @GetMapping( value = "/{idAziendaAgricola}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public List<SerraModel> findSerraByIdAziendaAgricola ( @PathVariable UUID idAziendaAgricola ) throws Exception {
        logger.info( "i'm in the controller to find an serra by AziendaAgricola id ..." );
        return serraService.findSerraByIdAziendaAgricola( idAziendaAgricola );
    }

}


