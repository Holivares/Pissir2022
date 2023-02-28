package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dao.Serra;
import edu.uniupo.coltivazioni.services.SerraServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping("v1/serra")
public class SerraController {

    SerraServices serraServices;

    public SerraController(SerraServices serraServices){
        this.serraServices = serraServices;
    }
    @GetMapping(value = "/{id}",produces = "application/json")
    public Serra getSerra(@PathVariable Long id){
        return serraServices.getSerra(id);
    }
}
