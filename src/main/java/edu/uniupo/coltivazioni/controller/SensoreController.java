package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOSensore;
import edu.uniupo.coltivazioni.services.SensoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/sensori" )
public class SensoreController {

    SensoreServices sensoreServices;

    @Autowired
    public SensoreController ( SensoreServices sensoreServices ) {
        this.sensoreServices = sensoreServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOSensore getSensore ( @PathVariable Long id ) {
        return sensoreServices.getSensore( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOSensore createSensore ( @RequestBody DTOSensore dtoSensore ) {
        System.out.println( "je suis dans la méthode create" );
        return sensoreServices.saveSensore( dtoSensore );
    }

    @PatchMapping(produces = "application/json")
    public DTOSensore updateSensore(@RequestBody DTOSensore dtoSensore){
        System.out.println("Je suis dans la méthode update");
        return sensoreServices.updateSensore(dtoSensore);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public DTODeletedResponse deleteSensore(@PathVariable Long id){
        return sensoreServices.deleteSensore(id);
    }

}
