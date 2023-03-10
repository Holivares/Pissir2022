package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOUtente;

/**
 * @author
 * @author
 */
public interface UtenteServices {
    DTOUtente getUtente ( Long idUtente );

    DTOUtente saveUtente ( DTOUtente dtoUtente );

    DTOUtente updateUtente ( DTOUtente dtoUtente );

    DTODeletedResponse deleteUtente ( Long idUtente );
}
