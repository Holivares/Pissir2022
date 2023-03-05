package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dao.Misura;
import edu.uniupo.coltivazioni.dto.DTOMisura;
import edu.uniupo.coltivazioni.services.MisuraServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DTOMisura getMisura(@PathVariable Long id){
        return misuraServices.getMisura(id);
    }

    @PostMapping(produces = "application/json")
    public DTOMisura createMisura(@RequestBody DTOMisura dtoMisura) {
        System.out.println("je suis dans la méthode create");
        return misuraServices.saveMisura(dtoMisura);
    }
}
