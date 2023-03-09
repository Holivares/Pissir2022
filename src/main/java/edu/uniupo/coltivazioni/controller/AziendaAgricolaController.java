package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTOAziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.services.AziendaAgricolaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Evrard
 * @author
 */
//Definisce gli endpoint
@RestController
@RequestMapping( "v1/aziende" )
public class AziendaAgricolaController {

    AziendaAgricolaServices aziendaAgricolaServices;

    //injection de dependances della DB, durant l'injection de dependances Spring va remplacer l'interface par son impl
    //pour éviter le couplage fort
    @Autowired
    public AziendaAgricolaController ( AziendaAgricolaServices aziendaAgricolaServices ) {
        this.aziendaAgricolaServices = aziendaAgricolaServices;
    }

    //questo valore "id" verrà recuperata nel mio metodo
    //produces definisce il formato con quale verrano ritornati i dati
    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOAziendaAgricola getAziendaAgricola ( @PathVariable Long id ) {
        return aziendaAgricolaServices.getAziendaAgricola( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOAziendaAgricola createAziendaAgricola ( @RequestBody DTOAziendaAgricola dtoAziendaAgricola ) {
        System.out.println( "je suis dans la méthode create " + dtoAziendaAgricola.toString() );
        return aziendaAgricolaServices.saveAzienda( dtoAziendaAgricola );
    }

    @PatchMapping( produces = "application/json" )
    public DTOAziendaAgricola updateAziendaAgricola ( @RequestBody DTOAziendaAgricola dtoAziendaAgricola ) {
        System.out.println( "je suis dans la méthode update" );
        return aziendaAgricolaServices.updateAzienda( dtoAziendaAgricola );
    }

    @DeleteMapping( value = "/{id}", produces = "application/json" )
    public DTODeletedResponse deleteAziendaAricola ( @PathVariable Long id ) {
        return aziendaAgricolaServices.deleteAzienda( id );
    }
}

