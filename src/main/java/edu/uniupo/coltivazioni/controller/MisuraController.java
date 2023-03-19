package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTOMisura;
import edu.uniupo.coltivazioni.services.MisuraServices;
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
@RequestMapping(value = "v1/misure")
public class MisuraController {

    private final MisuraServices misuraServices;
    private final Logger logger = LoggerFactory.getLogger(MisuraController.class);

    @Autowired
    public MisuraController(MisuraServices misuraServices) {
        this.misuraServices = misuraServices;
    }

    @PostMapping(value = "/", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public DTOMisura createMisura(@RequestBody DTOMisura dtoMisura) {
        logger.info("i'm in controller...");
        return misuraServices.createMisura(dtoMisura);
    }

    @GetMapping(value = "/{idMisura}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public DTOMisura findMisuraById(@PathVariable UUID idMisura) {
        logger.info("i'm in the controller...");
        return misuraServices.findMisuraById(idMisura);
    }

    @GetMapping(value = "/{idSensore}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public DTOMisura findMisuraBySensoreId(@PathVariable UUID idSensore) {
        logger.info("i'm in the controller...");
        return misuraServices.findMisuraBySensoreId(idSensore);
    }
}
