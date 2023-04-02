package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.AziendaAgricolaModel;
import edu.uniupo.pissir.model.DeleteResponseModel;
import jakarta.servlet.http.HttpSession;

import java.util.UUID;

public interface AziendaAgricolaService {
    AziendaAgricolaModel createAziendaAgricola ( HttpSession session, AziendaAgricolaModel aziendaAgricolaModel ) throws Exception;

    AziendaAgricolaModel updateAziendaAgricola ( HttpSession session, AziendaAgricolaModel aziendaAgricolaModel ) throws Exception;

    DeleteResponseModel deleteAziendaAgricola ( HttpSession session, UUID idAziendaAgricola ) throws Exception;

    AziendaAgricolaModel findAziendaAgricolaByIdUser ( HttpSession session, UUID idUtente ) throws Exception;

    AziendaAgricolaModel findAziendaAgricolaById ( HttpSession session, UUID idAziendaAgricola ) throws Exception;

    AziendaAgricolaModel findAziendaAgricolaByName ( HttpSession session, String nome ) throws Exception;

}
