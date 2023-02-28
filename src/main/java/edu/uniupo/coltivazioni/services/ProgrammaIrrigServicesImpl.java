package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.ProgrammaIrrig;
import edu.uniupo.coltivazioni.repositori.ProgrammaIritigRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
@Service
public class ProgrammaIrrigServicesImpl implements ProgrammaIrrigServices{
    ProgrammaIritigRepositori programmaIritigRepositori;
    @Autowired
    public ProgrammaIrrigServicesImpl(ProgrammaIritigRepositori programmaIritigRepositori){
        this.programmaIritigRepositori = programmaIritigRepositori;
    }

    @Override
    public ProgrammaIrrig geProgrammaIrrig(Long id) {
        final ProgrammaIrrig programmaIrrig = new ProgrammaIrrig();
        return programmaIritigRepositori.findById(id).orElse(programmaIrrig);
    }
}
