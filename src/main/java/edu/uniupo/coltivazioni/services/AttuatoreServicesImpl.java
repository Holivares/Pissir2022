package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Attuatore;
import edu.uniupo.coltivazioni.repositori.AttuatoreRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
@Service
public class AttuatoreServicesImpl implements AttuatoreServices{

    AttuatoreRepositori attuatoreRepositori;
    @Autowired
    public AttuatoreServicesImpl(AttuatoreRepositori attuatoreRepositori){
        this.attuatoreRepositori = attuatoreRepositori;
    }
    @Override
    public Attuatore getAttuatore(Long id) {
       final Attuatore attuatore = new Attuatore();
       return attuatoreRepositori.findById(id).orElse(attuatore);
    }
}
