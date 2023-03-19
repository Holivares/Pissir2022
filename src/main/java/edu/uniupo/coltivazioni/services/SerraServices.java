package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOSerra;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface SerraServices {
    DTOSerra createSerra(DTOSerra dtoSerra);
    DTOSerra updateSerra(DTOSerra dtoSerra);
    DTODeleteResponse deleteSerra(UUID idSerra);
    DTOSerra findSerraByIdAziendaAgricola(UUID idAziendaAgricola);
}
