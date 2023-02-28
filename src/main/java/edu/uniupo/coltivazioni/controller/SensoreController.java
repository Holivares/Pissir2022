package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dao.Sensore;
import edu.uniupo.coltivazioni.services.SensoreServices;
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
@RequestMapping("v1/sensori")
public class SensoreController {

    SensoreServices sensoreServices;
    @Autowired
    public SensoreController(SensoreServices sensoreServices){
        this.sensoreServices = sensoreServices;
    }
    @GetMapping(value = "/{id}",produces = "application/json")
    public Sensore getSensore(@PathVariable Long id){
        return sensoreServices.getSensore(id);
    }

}
