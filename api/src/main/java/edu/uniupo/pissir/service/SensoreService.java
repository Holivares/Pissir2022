package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.SensoreModel;

import java.util.List;
import java.util.UUID;

public interface SensoreService {
    SensoreModel createSensore ( SensoreModel sensoreModel ) throws Exception;

    List<SensoreModel> findSensoreByIdSerra ( UUID idSerra ) throws Exception;
}
