package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dao.Utente;
import edu.uniupo.coltivazioni.services.UtenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping("v1/utente")
public class UtenteController {
    UtenteServices utenteServices;
    @Autowired
    public UtenteController(UtenteServices utenteServices){
        this.utenteServices = utenteServices;
    }
    @GetMapping(value = "/{id}",produces = "application/json")
    public Utente getUtente(@PathVariable Long id){
        return utenteServices.getUtente(id);
    }
}
