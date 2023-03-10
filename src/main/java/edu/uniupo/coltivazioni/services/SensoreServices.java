package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOSensore;

/**
 * @author
 * @author
 */
public interface SensoreServices {
    DTOSensore getSensore ( Long idSensore );

    DTOSensore saveSensore ( DTOSensore dtoSensore );

    DTOSensore updateSensore ( DTOSensore dtoSensore );

    DTODeletedResponse deleteSensore ( Long idSensore );
}
