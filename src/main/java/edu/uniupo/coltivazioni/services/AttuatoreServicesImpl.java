package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOAttuatore;
import edu.uniupo.coltivazioni.repositori.AttuatoreRepositori;

import java.util.UUID;

/**
 * @author
 * @author
 */
public class AttuatoreServicesImpl implements AttuatoreServices{

    AttuatoreRepositori attuatoreRepositori;
    @Override
    public DTOAttuatore findAttuatoreByIdSerra(UUID idSerra) {
        return null;
    }

    @Override
    public DTOAttuatore enableAttuatore(UUID idAttuatore) {
        return null;
    }

    @Override
    public DTOAttuatore disableAttuatore(UUID idAttuatore) {
        return null;
    }


}
