package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Misura;
import edu.uniupo.coltivazioni.dto.DTOMisura;

/**
 * @author
 * @author
 */
public interface MisuraServices {
    DTOMisura getMisura(Long idMisura);

    DTOMisura saveMisura(DTOMisura dtoMisura);
}
