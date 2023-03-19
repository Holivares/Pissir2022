package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOUtente;
import edu.uniupo.coltivazioni.dto.DTOUtenteAutenticazione;
import edu.uniupo.coltivazioni.services.UtenteServices;
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
@RequestMapping(value = "v1/utenti")
public class UtenteController {

    private final UtenteServices utenteServices;
    private final Logger logger = LoggerFactory.getLogger(UtenteController.class);

    @Autowired
    public UtenteController(UtenteServices utenteServices) {
        this.utenteServices = utenteServices;
    }

    @PostMapping(value = "/", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public DTOUtente createUtente(@RequestBody DTOUtente dtoUtente) {
        logger.info("i'm in the controller to create an utente");
        return utenteServices.createUtente(dtoUtente);
    }

    @PutMapping(value = "/", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public DTOUtente updateUtente(@RequestBody DTOUtente dtoUtente) {
        logger.info("i'm in the controller to update an utente ");
        return utenteServices.updateUtente(dtoUtente);
    }

    @DeleteMapping(value = "/{idSerra}")
    @ResponseStatus(value = HttpStatus.OK)
    public DTODeleteResponse deleteUtenteById(@PathVariable UUID idUtente) {
        logger.info("i'm in the controller to delete an utente by idUtente");
        return utenteServices.deleteUtenteById(idUtente);
    }

    @PostMapping(value = "/utenteAutenticazione", produces = "application/json")
    public DTOUtente findUtenteByEmailAndPassword(@RequestBody DTOUtenteAutenticazione dtoUtenteAutenticazione)  {
        logger.info("i'm in the controller to find utente by email and password");
        return utenteServices.findUtenteByEmailAndPassword(dtoUtenteAutenticazione.getEmail(), dtoUtenteAutenticazione.getPassword());
    }
}
