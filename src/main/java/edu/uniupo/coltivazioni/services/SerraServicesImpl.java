package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOSerra;
import edu.uniupo.coltivazioni.repositori.SerraRepositori;

import java.util.UUID;

/**
 * @author
 * @author
 */
public class SerraServicesImpl implements SerraServices{

    SerraRepositori serraRepositori;
    @Override
    public DTOSerra createSerra(DTOSerra serra) {
        return null;
    }

    @Override
    public DTOSerra updateSerra(DTOSerra dtoSerra) {
        return null;
    }

    @Override
    public DTODeleteResponse deleteSerra(UUID idSerra) {
        return null;
    }


    @Override
    public DTOSerra findSerraByIdAziendaAgricola(UUID idAziendaAgricola) {
        return null;
    }
}
