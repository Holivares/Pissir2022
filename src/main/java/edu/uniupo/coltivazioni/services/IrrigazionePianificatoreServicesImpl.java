package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOIrrigazionePianificatore;
import edu.uniupo.coltivazioni.repositori.IrrigazionePianificatoreRepositori;

import java.util.UUID;

/**
 * @author
 * @author
 */
public class IrrigazionePianificatoreServicesImpl implements IrrigazionePianificatoreServices{

    IrrigazionePianificatoreRepositori irrigazionePianificatoreRepositori;
    @Override
    public DTOIrrigazionePianificatore createIrrigazionePianificatore(DTOIrrigazionePianificatore irrigazionePianificatore) {
        return null;
    }

    @Override
    public DTOIrrigazionePianificatore updateIrrigazionePianificatore(DTOIrrigazionePianificatore dtoIrrigazionePianificatore) {
        return null;
    }

    @Override
    public DTODeleteResponse deleteIrrigazionePianificatore(UUID idIrrigazionePianificatore) {
    return null;
    }


    @Override
    public DTOIrrigazionePianificatore findIrrigazionePianificatoreByIdAziendaAgricola(UUID idAziendaAgricola) {
        return null;
    }

    @Override
    public DTOIrrigazionePianificatore findIrrigazionePianificatoreByIdserra(UUID idSerra) {
        return null;
    }
}
