package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOSensore;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface SensoreServices {
    DTOSensore findSensoreByIdSerra(UUID idSerra);
}
