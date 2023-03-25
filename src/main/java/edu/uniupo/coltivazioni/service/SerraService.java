package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.model.SerraModel;

import java.util.UUID;

public interface SerraService {
    SerraModel createSerra ( SerraModel serraModel );

    SerraModel updateSerra ( SerraModel serraModel );

    DeleteResponseModel deleteSerra ( UUID idSerra );

    SerraModel findSerraByIdAziendaAgricola ( UUID idAziendaAgricola );
}
