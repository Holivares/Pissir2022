package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOIrrigazionePianificatore;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface IrrigazionePianificatoreServices {
    DTOIrrigazionePianificatore createIrrigazionePianificatore ( DTOIrrigazionePianificatore dtoIrrigazionePianificatore );

    DTOIrrigazionePianificatore updateIrrigazionePianificatore ( DTOIrrigazionePianificatore dtoIrrigazionePianificatore );

    DTODeleteResponse deleteIrrigazionePianificatoreById ( UUID idIrrigazionePianificatore );

    DTOIrrigazionePianificatore findIrrigazionePianificatoreByIdAziendaAgricola ( UUID idAziendaAgricola );

    DTOIrrigazionePianificatore findIrrigazionePianificatoreByIdserra ( UUID idSerra );
}
