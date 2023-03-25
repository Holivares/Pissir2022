package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.AziendaAgricolaModel;
import edu.uniupo.coltivazioni.model.DeleteResponseModel;

import java.util.UUID;

public interface AziendaAgricolaService {
    AziendaAgricolaModel createAziendaAgricola ( AziendaAgricolaModel aziendaAgricolaModel );

    AziendaAgricolaModel updateAziendaAgricola ( AziendaAgricolaModel aziendaAgricolaModel );

    DeleteResponseModel deleteAziendaAgricola ( UUID idAziendaAgricola );

    AziendaAgricolaModel findAziendaAgricolaByIdUser ( UUID idUtente );

    AziendaAgricolaModel findAziendaAgricolaById ( UUID idAziendaAgricola );

    AziendaAgricolaModel findAziendaAgricolaByName ( String nome );
}
