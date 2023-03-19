package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTOAziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.services.AziendaAgricolaServices;
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
@RequestMapping("v1/aziende")
public class AziendaAgricolaController {
    private final AziendaAgricolaServices aziendaAgricolaServices;
    private final Logger logger = LoggerFactory.getLogger(AziendaAgricolaController.class);

    @Autowired
    public AziendaAgricolaController(AziendaAgricolaServices aziendaAgricolaServices) {
        this.aziendaAgricolaServices = aziendaAgricolaServices;
    }
    @PostMapping(value = "/", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public DTOAziendaAgricola createAziendaAgricola(@RequestBody DTOAziendaAgricola dtoAziendaAgricola){
        logger.info("i'm in the controller to create an azienda agricola ");
        return aziendaAgricolaServices.createAziendaAgricola(dtoAziendaAgricola);
    }
    @PutMapping(value = "/", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public DTOAziendaAgricola updateAziendaAgricola(@RequestBody DTOAziendaAgricola dtoAziendaAgricola){
        logger.info("i'm in the controller to update un azienda agricola");
        return aziendaAgricolaServices.updateAziendaAgricola(dtoAziendaAgricola);
    }
    @DeleteMapping(value = "/{idAziendaAgricola}")
    @ResponseStatus(value = HttpStatus.OK)
    public DTODeleteResponse deleteAziendaAgricola(@PathVariable  UUID idAziendaAgricola){
        logger.info("i'm in the controller to delete un azienda agricola");
        return aziendaAgricolaServices.deleteAziendaAgricola(idAziendaAgricola);
    }
    @GetMapping(value = "/{idUtente}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public DTOAziendaAgricola findAziendaAgricolaByIdUser(@PathVariable UUID idUtente){
        logger.info("i'm in the controller to find an azienda agricola by idUser");
        return aziendaAgricolaServices.findAziendaAgricolaByIdUser(idUtente);
    }
    @GetMapping(value = "/{idAziendaAgricola}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public DTOAziendaAgricola findAziendaAgricolaByid(@PathVariable UUID idAziendaAgricola){
        logger.info("i'm in the controller to find an azienda agricola by idAziendaAgricola");
        return aziendaAgricolaServices.findAziendaAgricolaById(idAziendaAgricola);
    }
    @GetMapping(value = "/{nome}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public DTOAziendaAgricola findAziendaAgricolaByName(@PathVariable String nome){
        logger.info("i'm the controller to find an azienda agricola by name ");
        return aziendaAgricolaServices.findAziendaAgricolaByName(nome);
    }
}
