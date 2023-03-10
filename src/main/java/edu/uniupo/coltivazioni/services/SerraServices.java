package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOSerra;

/**
 * @author
 * @author
 */
public interface SerraServices {

    DTOSerra getSerra ( Long idSerra );

    DTOSerra saveSerra ( DTOSerra dtoSerra );

    DTOSerra updateSerra ( DTOSerra dtoSerra );

    DTODeletedResponse deleteSerra ( Long idSerra );
}
