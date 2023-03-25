package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.AziendaAgricolaModel;
import edu.uniupo.coltivazioni.model.DeleteResponseModel;

import java.util.UUID;

public interface AziendaAgricolaService {
    AziendaAgricolaModel createAziendaAgricola ( AziendaAgricolaModel aziendaAgricolaModel ) throws Exception;

    AziendaAgricolaModel updateAziendaAgricola ( AziendaAgricolaModel aziendaAgricolaModel ) throws Exception;

    DeleteResponseModel deleteAziendaAgricola ( UUID idAziendaAgricola ) throws Exception;

    AziendaAgricolaModel findAziendaAgricolaByIdUser ( UUID idUtente ) throws Exception;

    AziendaAgricolaModel findAziendaAgricolaById ( UUID idAziendaAgricola ) throws Exception;

    AziendaAgricolaModel findAziendaAgricolaByName ( String nome ) throws Exception;

}
