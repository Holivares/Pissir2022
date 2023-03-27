package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.SensoreModel;

import java.util.List;
import java.util.UUID;

public interface SensoreService {
    SensoreModel createSensore ( SensoreModel sensoreModel ) throws Exception;

    List<SensoreModel> findSensoreByIdSerra ( UUID idSerra ) throws Exception;
}
