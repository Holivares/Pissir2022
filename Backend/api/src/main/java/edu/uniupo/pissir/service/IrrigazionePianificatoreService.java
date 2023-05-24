package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.IrrigazionePianificatoreModel;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.UUID;

public interface IrrigazionePianificatoreService {
    IrrigazionePianificatoreModel createIrrigazionePianificatore ( HttpSession session,
                                                                   IrrigazionePianificatoreModel irrigazionePianificatoreModel ) throws Exception;

    IrrigazionePianificatoreModel updateIrrigazionePianificatore ( HttpSession session,
                                                                   IrrigazionePianificatoreModel irrigazionePianificatoreModel ) throws Exception;

    DeleteResponseModel deleteIrrigazionePianificatoreById ( HttpSession session, UUID idIrrigazionePianificatore ) throws Exception;

    List<IrrigazionePianificatoreModel> findIrrigazionePianificatoreByIdAziendaAgricola ( HttpSession session, UUID idAziendaAgricola ) throws Exception;

    List<IrrigazionePianificatoreModel> findIrrigazionePianificatoreByIdserra ( HttpSession session, UUID idSerra ) throws Exception;
}
