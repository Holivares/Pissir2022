package edu.uniupo.coltivazioni.controller;

import edu.uniupo.coltivazioni.dao.ProgrammaIrrig;
import edu.uniupo.coltivazioni.services.ProgrammaIrrigServices;
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
@RequestMapping("v1/programma_irrig")
public class ProgrammaIrrigController {

    ProgrammaIrrigServices programmaIrrigServices;
    @Autowired
    public ProgrammaIrrigController(ProgrammaIrrigServices programmaIrrigServices){
        this.programmaIrrigServices = programmaIrrigServices;
    }
    @GetMapping(value = "/{id}",produces = "application/json")
    public ProgrammaIrrig getProgrammaIrrig(@PathVariable Long id){
        return programmaIrrigServices.geProgrammaIrrig(id);
    }
}
