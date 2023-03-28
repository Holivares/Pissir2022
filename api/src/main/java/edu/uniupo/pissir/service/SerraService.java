package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.SerraModel;

import java.util.List;
import java.util.UUID;

public interface SerraService {
    SerraModel createSerra ( SerraModel serraModel ) throws Exception;

    SerraModel updateSerra ( SerraModel serraModel ) throws Exception;

    DeleteResponseModel deleteSerra ( UUID idSerra ) throws Exception;

    List<SerraModel> findSerraByIdAziendaAgricola ( UUID idAziendaAgricola ) throws Exception;
}
