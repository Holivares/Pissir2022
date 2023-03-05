package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.ProgrammaIrrig;
import edu.uniupo.coltivazioni.dto.DTOProgrammaIrrig;

/**
 * @author
 * @author
 */
public interface ProgrammaIrrigServices {
    DTOProgrammaIrrig geProgrammaIrrig(Long idProgramma);

    DTOProgrammaIrrig saveProgramma(DTOProgrammaIrrig dtoProgrammaIrrig);
}
