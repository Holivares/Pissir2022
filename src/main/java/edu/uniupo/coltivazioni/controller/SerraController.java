package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOSerra;
import edu.uniupo.coltivazioni.services.SerraServices;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/serra" )
public class SerraController {

    SerraServices serraServices;

    public SerraController ( SerraServices serraServices ) {
        this.serraServices = serraServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOSerra getSerra ( @PathVariable Long id ) {
        return serraServices.getSerra( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOSerra createSerra ( @RequestBody DTOSerra dtoSerra ) {
        System.out.println( "je suis dans la méthode create" );
        return serraServices.saveSerra( dtoSerra );
    }
    @PatchMapping(produces = "application/json")
    public DTOSerra updateSerra(@RequestBody DTOSerra dtoSerra){
        System.out.println("Je suis dans la méthode update");
        return serraServices.updateSerra(dtoSerra);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public DTODeletedResponse deletedSerra(@PathVariable Long id){
        return serraServices.deleteSerra(id);
    }
}
