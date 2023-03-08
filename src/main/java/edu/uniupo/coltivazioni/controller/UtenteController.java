package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTOUtente;
import edu.uniupo.coltivazioni.services.UtenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/utente" )
public class UtenteController {
    UtenteServices utenteServices;

    @Autowired
    public UtenteController ( UtenteServices utenteServices ) {
        this.utenteServices = utenteServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOUtente getUtente ( @PathVariable Long id ) {
        return utenteServices.getUtente( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOUtente createUtente ( @RequestBody DTOUtente dtoUtente ) {
        System.out.println( "je suis dans la méthode create" );
        return utenteServices.saveUtente( dtoUtente );
    }
}
