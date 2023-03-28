package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.AziendaAgricolaModel;
import edu.uniupo.pissir.model.DeleteResponseModel;

import java.util.UUID;

public interface AziendaAgricolaService {
    AziendaAgricolaModel createAziendaAgricola ( AziendaAgricolaModel aziendaAgricolaModel ) throws Exception;

    AziendaAgricolaModel updateAziendaAgricola ( AziendaAgricolaModel aziendaAgricolaModel ) throws Exception;

    DeleteResponseModel deleteAziendaAgricola ( UUID idAziendaAgricola ) throws Exception;

    AziendaAgricolaModel findAziendaAgricolaByIdUser ( UUID idUtente ) throws Exception;

    AziendaAgricolaModel findAziendaAgricolaById ( UUID idAziendaAgricola ) throws Exception;

    AziendaAgricolaModel findAziendaAgricolaByName ( String nome ) throws Exception;

}
