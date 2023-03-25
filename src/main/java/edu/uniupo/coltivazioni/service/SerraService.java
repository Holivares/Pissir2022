package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.model.SerraModel;

import java.util.List;
import java.util.UUID;

public interface SerraService {
    SerraModel createSerra ( SerraModel serraModel ) throws Exception;

    SerraModel updateSerra ( SerraModel serraModel ) throws Exception;

    DeleteResponseModel deleteSerra ( UUID idSerra ) throws Exception;

    List<SerraModel> findSerraByIdAziendaAgricola ( UUID idAziendaAgricola ) throws Exception;
}
