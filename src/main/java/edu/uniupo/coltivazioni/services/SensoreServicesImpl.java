package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Sensore;
import edu.uniupo.coltivazioni.repositori.SensoreRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
@Service
public class SensoreServicesImpl implements SensoreServices{

    SensoreRepositori sensoreRepositori;
    @Autowired
    public SensoreServicesImpl(SensoreRepositori sensoreRepositori){
        this.sensoreRepositori = sensoreRepositori;
    }

    @Override
    public Sensore getSensore(Long id) {
        final Sensore sensore = new Sensore();
        return sensoreRepositori.findById(id).orElse(sensore);
    }
}
