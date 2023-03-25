package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.MisuraModel;

import java.util.UUID;

public interface MisuraService {

    MisuraModel createMisura ( MisuraModel misuraModel );

    MisuraModel findMisuraById ( UUID idMisura );

    MisuraModel findMisuraBySensoreId ( UUID idSensore );
}
