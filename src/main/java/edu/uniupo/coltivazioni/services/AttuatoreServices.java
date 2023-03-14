package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOAttuatore;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface AttuatoreServices {

    DTOAttuatore findAttuatoreByIdSerra(UUID idSerra);
    DTOAttuatore enableAttuatore(UUID idAttuatore);
    DTOAttuatore disableAttuatore(UUID idAttuatore);
}
