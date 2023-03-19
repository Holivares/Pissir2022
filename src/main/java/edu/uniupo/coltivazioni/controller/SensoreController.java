package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTOSensore;
import edu.uniupo.coltivazioni.services.SensoreServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping(value = "v1/sensori")
public class SensoreController {

    private final SensoreServices sensoreServices;
    private final Logger logger = LoggerFactory.getLogger(SensoreController.class);
    @Autowired
    public SensoreController(SensoreServices sensoreServices) {
        this.sensoreServices = sensoreServices;
    }
    @PostMapping(value = "/", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public DTOSensore createSensore(DTOSensore dtoSensore){
        logger.info("i'm in controller to create an sensore");
        return sensoreServices.createSensore(dtoSensore);
    }

    @GetMapping(value = "/{idSerra}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.FOUND)
    public DTOSensore findSensoreByIdSerra(@PathVariable UUID idSerra){
        logger.info("i'm in the controller to find an sensore by idSerra");
        return sensoreServices.findSensoreByIdSerra(idSerra);
    }
}
