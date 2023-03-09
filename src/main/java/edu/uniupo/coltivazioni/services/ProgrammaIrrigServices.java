package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOProgrammaIrrig;

/**
 * @author
 * @author
 */
public interface ProgrammaIrrigServices {
    DTOProgrammaIrrig getProgrammaIrrig ( Long idProgramma );

    DTOProgrammaIrrig saveProgramma ( DTOProgrammaIrrig dtoProgrammaIrrig );

    DTOProgrammaIrrig updateProgramma(DTOProgrammaIrrig dtoProgrammaIrrig);

    DTODeletedResponse deleteProgramma(Long idProgramma);
}
