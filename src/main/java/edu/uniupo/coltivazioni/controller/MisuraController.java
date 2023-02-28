package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dao.Misura;
import edu.uniupo.coltivazioni.services.MisuraServices;
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
@RequestMapping("v1/misure")
public class MisuraController {
    MisuraServices misuraServices;
    @Autowired
    public MisuraController(MisuraServices misuraServices){
        this.misuraServices = misuraServices;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public Misura getMisura(@PathVariable Long id){
        return misuraServices.getMisura(id);
    }
}
