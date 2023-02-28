package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Utente;
import edu.uniupo.coltivazioni.repositori.UtenteRepositori;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
@Service
public class UtenteServicesImpl implements UtenteServices{

    UtenteRepositori utenteRepositori;
    public UtenteServicesImpl(UtenteRepositori utenteRepositori){
        this.utenteRepositori = utenteRepositori;
    }
    @Override
    public Utente getUtente(Long id) {
        final Utente utente = new Utente();
        return  utenteRepositori.findById(id).orElse(utente);
    }
}
