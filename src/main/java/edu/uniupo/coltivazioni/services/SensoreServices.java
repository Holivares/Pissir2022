package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Sensore;
import edu.uniupo.coltivazioni.dto.DTOSensore;

/**
 * @author
 * @author
 */
public interface SensoreServices {
    DTOSensore getSensore(Long idSensore);

    DTOSensore saveSensore(DTOSensore dtoSensore);
}
