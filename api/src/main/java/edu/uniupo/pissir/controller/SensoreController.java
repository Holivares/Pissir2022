package edu.uniupo.pissir.controller;

import edu.uniupo.pissir.model.SensoreModel;
import edu.uniupo.pissir.service.SensoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( value = "v1/sensori" )
public class SensoreController {

    private final SensoreService sensoreService;
    private final Logger logger = LoggerFactory.getLogger( SensoreController.class );

    @Autowired
    public SensoreController ( SensoreService sensoreService ) {
        this.sensoreService = sensoreService;
    }

    @PostMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.CREATED )
    public SensoreModel createSensore ( @RequestBody SensoreModel sensoreModel ) throws Exception {
        logger.info( "i'm in the controller to create an sensore ..." );
        return sensoreService.createSensore( sensoreModel );
    }

    @GetMapping( value = "/{idSerra}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public List<SensoreModel> findSensoreByIdSerra ( @PathVariable UUID idSerra ) throws Exception {
        logger.info( "i'm in the controller to find an sensore by idSerra ..." );
        return sensoreService.findSensoreByIdSerra( idSerra );
    }
}
