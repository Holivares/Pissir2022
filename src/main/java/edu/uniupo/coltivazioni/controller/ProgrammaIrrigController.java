package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOProgrammaIrrig;
import edu.uniupo.coltivazioni.services.ProgrammaIrrigServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping( "v1/programma_irrig" )
public class ProgrammaIrrigController {

    ProgrammaIrrigServices programmaIrrigServices;

    @Autowired
    public ProgrammaIrrigController ( ProgrammaIrrigServices programmaIrrigServices ) {
        this.programmaIrrigServices = programmaIrrigServices;
    }

    @GetMapping( value = "/{id}", produces = "application/json" )
    public DTOProgrammaIrrig getProgrammaIrrig ( @PathVariable Long id ) {
        return programmaIrrigServices.getProgrammaIrrig( id );
    }

    @PostMapping( produces = "application/json" )
    public DTOProgrammaIrrig createProgramma ( @RequestBody DTOProgrammaIrrig dtoProgrammaIrrig ) {
        System.out.println( "je suis dans la méthode create" );
        return programmaIrrigServices.saveProgramma( dtoProgrammaIrrig );
    }
    @PatchMapping(produces = "application/json")
        public DTOProgrammaIrrig updateProgramma (@RequestBody DTOProgrammaIrrig dtoProgrammaIrrig ){
            System.out.println( "je suis dans la méthode update" );
            return programmaIrrigServices.updateProgramma(dtoProgrammaIrrig);

        }

    @DeleteMapping
    DTODeletedResponse deleteProgramma(@PathVariable Long id){
        return programmaIrrigServices.deleteProgramma(id);
    }
}
