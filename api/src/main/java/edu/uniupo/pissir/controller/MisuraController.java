package edu.uniupo.pissir.controller;

import edu.uniupo.pissir.model.MisuraModel;
import edu.uniupo.pissir.service.MisuraService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( value = "v1/misure" )
public class MisuraController {

    private final MisuraService misuraService;
    private final Logger logger = LoggerFactory.getLogger( MisuraController.class );

    @Autowired
    public MisuraController ( MisuraService misuraService ) {
        this.misuraService = misuraService;
    }

    @PostMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.CREATED )
    public MisuraModel createMisura ( HttpSession session, @RequestBody MisuraModel misuraModel ) throws Exception {
        logger.info( "i'm in the controller to create an misura ..." );
        return misuraService.createMisura( session, misuraModel );
    }

    @GetMapping( value = "/{idMisura}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public MisuraModel findMisuraById ( HttpSession session, @PathVariable UUID idMisura ) throws Exception {
        logger.info( "i'm in the controller to find misura by id ..." );
        return misuraService.findMisuraById( session, idMisura );
    }

    @GetMapping( value = "/{idSensore}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public List<MisuraModel> findMisuraByIdSensore ( HttpSession session, @PathVariable UUID idSensore ) throws Exception {
        logger.info( "i'm in the controller to find misura by sensore id ..." );
        return misuraService.findMisuraBySensoreId( session, idSensore );
    }
}
