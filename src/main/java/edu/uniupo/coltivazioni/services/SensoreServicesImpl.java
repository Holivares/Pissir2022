package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOSensore;
import edu.uniupo.coltivazioni.repositori.SensoreRepositori;

import java.util.UUID;

/**
 * @author
 * @author
 */
public class SensoreServicesImpl implements  SensoreServices{

   private SensoreRepositori  sensoreRepositori;
    @Override
    public DTOSensore findSensoreByIdSerra(UUID idSerra) {
        return null;
    }
}
