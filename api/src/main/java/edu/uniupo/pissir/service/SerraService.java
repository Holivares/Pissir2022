package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.SerraModel;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.UUID;

public interface SerraService {
    SerraModel createSerra ( HttpSession session, SerraModel serraModel ) throws Exception;

    SerraModel updateSerra ( HttpSession session, SerraModel serraModel ) throws Exception;

    DeleteResponseModel deleteSerra ( HttpSession session, UUID idSerra ) throws Exception;

    List<SerraModel> findSerraByIdAziendaAgricola ( HttpSession session, UUID idAziendaAgricola ) throws Exception;
}
