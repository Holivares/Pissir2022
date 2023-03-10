package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOAziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;

/**
 * @author Evrard Holivares
 * @author
 */
//Implementazione della logica che spetta il cliente (es Stato: 200, Body: lista serre
//Listo i miei metodi
public interface AziendaAgricolaServices {
    DTOAziendaAgricola getAziendaAgricola ( Long idAziendaAgricola );

    DTOAziendaAgricola saveAzienda ( DTOAziendaAgricola aziendaAgricola );

    DTOAziendaAgricola updateAzienda ( DTOAziendaAgricola dtoAziendaAgricola );

    DTODeletedResponse deleteAzienda ( Long idAziendaAgricola );
}

