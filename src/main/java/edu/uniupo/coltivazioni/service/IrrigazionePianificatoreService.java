package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.model.IrrigazionePianificatoreModel;

import java.util.List;
import java.util.UUID;

public interface IrrigazionePianificatoreService {
    IrrigazionePianificatoreModel createIrrigazionePianificatore ( IrrigazionePianificatoreModel irrigazionePianificatoreModel ) throws Exception;

    IrrigazionePianificatoreModel updateIrrigazionePianificatore ( IrrigazionePianificatoreModel irrigazionePianificatoreModel ) throws Exception;

    DeleteResponseModel deleteIrrigazionePianificatoreById ( UUID idIrrigazionePianificatore ) throws Exception;

    List<IrrigazionePianificatoreModel> findIrrigazionePianificatoreByIdAziendaAgricola ( UUID idAziendaAgricola ) throws Exception;

    List<IrrigazionePianificatoreModel> findIrrigazionePianificatoreByIdserra ( UUID idSerra ) throws Exception;
}
