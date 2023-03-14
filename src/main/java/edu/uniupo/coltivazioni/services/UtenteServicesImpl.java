package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOUtente;
import edu.uniupo.coltivazioni.repositori.UtenteRepositori;

import java.util.UUID;

/**
 * @author
 * @author
 */
public class UtenteServicesImpl implements UtenteServices{

   private UtenteRepositori utenteRepositori;
    @Override
    public DTOUtente createUtente(DTOUtente utente) {
        return null;
    }

    @Override
    public DTOUtente updateUtente(DTOUtente dtoUtente) {
        return null;
    }

    @Override
    public DTODeleteResponse deleteUtente(UUID idUtente) {
        return null;
    }


    @Override
    public DTOUtente findUtenteByEmailAndPassword(String email, String password) {
        return null;
    }
}
