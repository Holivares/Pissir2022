package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.MisuraModel;

import java.util.List;
import java.util.UUID;

public interface MisuraService {

    MisuraModel createMisura ( MisuraModel misuraModel ) throws Exception;

    MisuraModel findMisuraById ( UUID idMisura ) throws Exception;

    List<MisuraModel> findMisuraBySensoreId ( UUID idSensore ) throws Exception;
}
