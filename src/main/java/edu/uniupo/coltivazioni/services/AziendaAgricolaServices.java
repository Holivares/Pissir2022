package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOAziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTODeleteResponse;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface AziendaAgricolaServices {
    DTOAziendaAgricola createAziendaAgricola ( DTOAziendaAgricola dtoAziendaAgricola );

    DTOAziendaAgricola updateAziendaAgricola ( DTOAziendaAgricola dtoAziendaAgricola );

    DTODeleteResponse deleteAziendaAgricola ( UUID idAziendaAgricola );

    DTOAziendaAgricola findAziendaAgricolaByIdUser ( UUID idUtente );

    DTOAziendaAgricola findAziendaAgricolaById ( UUID idAziendaAgricola );

    DTOAziendaAgricola findAziendaAgricolaByName ( String nome );
}
