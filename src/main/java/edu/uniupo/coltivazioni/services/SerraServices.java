package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOSerra;

/**
 * @author
 * @author
 */
public interface SerraServices {

    DTOSerra getSerra ( Long idSerra );

    DTOSerra saveSerra ( DTOSerra dtoSerra );
}
