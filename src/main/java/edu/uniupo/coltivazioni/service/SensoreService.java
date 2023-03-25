package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.SensoreModel;

import java.util.UUID;

public interface SensoreService {
    SensoreModel createSensore ( SensoreModel sensoreModel );

    SensoreModel findSensoreByIdSerra ( UUID idSerra );
}
