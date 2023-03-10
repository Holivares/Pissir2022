package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOMisura;

/**
 * @author
 * @author
 */
public interface MisuraServices {
    DTOMisura getMisura ( Long idMisura );

    DTOMisura saveMisura ( DTOMisura dtoMisura );

    DTOMisura updateMisura ( DTOMisura dtoMisura );

    DTODeletedResponse deleteMisura ( Long idMisura );
}
