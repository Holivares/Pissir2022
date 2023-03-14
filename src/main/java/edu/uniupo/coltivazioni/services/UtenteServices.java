package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOUtente;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface UtenteServices {
    DTOUtente createUtente(DTOUtente utente);
    DTOUtente updateUtente(DTOUtente dtoUtente);
    DTODeleteResponse deleteUtente(UUID idUtente);
    DTOUtente findUtenteByEmailAndPassword(String email, String password);
}
