package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Utente;
import edu.uniupo.coltivazioni.dto.DTOUtente;

/**
 * @author
 * @author
 */
public interface UtenteServices {
    DTOUtente getUtente(Long idUtente);

    DTOUtente saveUtente(DTOUtente dtoUtente);
}
