package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOIrrigazionePianificatore;
import edu.uniupo.coltivazioni.services.IrrigazionePianificatoreServices;
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
@RequestMapping("v1/piani")
public class IrrigazionePianificatoreController {

    private final IrrigazionePianificatoreServices irrigazionePianificatoreServices;
    private final Logger logger = LoggerFactory.getLogger(IrrigazionePianificatoreController.class);

    @Autowired
    public IrrigazionePianificatoreController(IrrigazionePianificatoreServices irrigazionePianificatoreServices) {
        this.irrigazionePianificatoreServices = irrigazionePianificatoreServices;
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public DTOIrrigazionePianificatore createIrrigazionePianificatore(@RequestBody DTOIrrigazionePianificatore dtoIrrigazionePianificatore) {
        logger.info("i'm in the controller to create an pianificatore");
        return irrigazionePianificatoreServices.createIrrigazionePianificatore(dtoIrrigazionePianificatore);
    }

    @PutMapping(produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public DTOIrrigazionePianificatore updateIrrigazionePianificatore(@RequestBody DTOIrrigazionePianificatore dtoIrrigazionePianificatore) {
        logger.info("i'm in the controller to update an pianificatore");
        return irrigazionePianificatoreServices.updateIrrigazionePianificatore(dtoIrrigazionePianificatore);
    }

    @DeleteMapping(value = "/{idIrrigazionePianificatore}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public DTODeleteResponse deleteIrrigazionePianificatore(@PathVariable UUID idIrrigazionePianificatore) {
        logger.info("i'm in controller to delete an pianificatore");
        return irrigazionePianificatoreServices.deleteIrrigazionePianificatoreById(idIrrigazionePianificatore);
    }

    @GetMapping(value = "/{idAziendaAgricola}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.FOUND)
    public DTOIrrigazionePianificatore findIrrigazionePianificatoreByIdAziendaAgricola(@PathVariable UUID idAziendaAgricola) {
        logger.info("i'm in the controller to find an pianificatore by idAziendaAgricola");
        return irrigazionePianificatoreServices.findIrrigazionePianificatoreByIdAziendaAgricola(idAziendaAgricola);
    }

    @GetMapping(value = "/{idSerra}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.FOUND)
    public DTOIrrigazionePianificatore findIrrigazionePianificatoreByIdserra(@PathVariable UUID idSerra) {
        logger.info("i'm in controller to find an pianificatore by idSerra");
        return irrigazionePianificatoreServices.findIrrigazionePianificatoreByIdserra(idSerra);
    }

}
