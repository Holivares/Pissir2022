package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTOAttuatore;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.services.AttuatoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/attuatori" )
public class AttuatoreController {
    AttuatoreServices attuatoreServices;

    @Autowired
    public AttuatoreController ( AttuatoreServices attuatoreServices ) {
        this.attuatoreServices = attuatoreServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOAttuatore getAttuatore ( @PathVariable Long id ) {
        return attuatoreServices.getAttuatore( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOAttuatore createAttuatore ( @RequestBody DTOAttuatore dtoAttuatore ) {
        System.out.println( "je suis dans la méthode create" );
        return attuatoreServices.saveAttuatore( dtoAttuatore );
    }

    @PatchMapping(produces = "application/json")
    public DTOAttuatore updateAttuatore(@RequestBody DTOAttuatore dtoAttuatore){
        System.out.println( "je suis dans la méthode update" );
        return attuatoreServices.updateProgramma(dtoAttuatore);
    }
    @DeleteMapping(value = "/{id}",produces = "application/json")
    public DTODeletedResponse deleteAttuatore(@PathVariable Long id){
        return  attuatoreServices.deleteAttuatore(id);
    }
}
