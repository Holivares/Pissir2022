package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Misura;
import edu.uniupo.coltivazioni.repositori.MisuraRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
@Service
public class MisuraServicesImpl implements MisuraServices {

    MisuraRepositori misuraRepositori;
    @Autowired
    public MisuraServicesImpl(MisuraRepositori misuraRepositori){
        this.misuraRepositori = misuraRepositori;
    }

    @Override
    public Misura getMisura(Long id) {
        final Misura misura = new Misura();
        return misuraRepositori.findById(id).orElse(misura);
    }
}
