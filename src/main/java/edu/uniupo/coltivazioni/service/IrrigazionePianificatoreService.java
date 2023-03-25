package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.model.IrrigazionePianificatoreModel;

import java.util.UUID;

public interface IrrigazionePianificatoreService {
    IrrigazionePianificatoreModel createIrrigazionePianificatore ( IrrigazionePianificatoreModel irrigazionePianificatoreModel );

    IrrigazionePianificatoreModel updateIrrigazionePianificatore ( IrrigazionePianificatoreModel irrigazionePianificatoreModel );

    DeleteResponseModel deleteIrrigazionePianificatoreById ( UUID idIrrigazionePianificatore );

    IrrigazionePianificatoreModel findIrrigazionePianificatoreByIdAziendaAgricola ( UUID idAziendaAgricola );

    IrrigazionePianificatoreModel findIrrigazionePianificatoreByIdserra ( UUID idSerra );
}
