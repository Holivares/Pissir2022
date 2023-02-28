package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dao.Attuatore;
import edu.uniupo.coltivazioni.services.AttuatoreServices;
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
@RequestMapping("v1/attuatori")
public class AttuatoreController {
    AttuatoreServices attuatoreServices;
    @Autowired
    public AttuatoreController(AttuatoreServices attuatoreServices) {
        this.attuatoreServices = attuatoreServices;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public Attuatore getAttuatore(@PathVariable Long id){
            return attuatoreServices.getAttuatore(id);
        }
}
