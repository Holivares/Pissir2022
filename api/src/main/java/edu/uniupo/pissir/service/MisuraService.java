package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.MisuraModel;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.UUID;

public interface MisuraService {

    MisuraModel createMisura ( HttpSession session, MisuraModel misuraModel ) throws Exception;

    MisuraModel findMisuraById ( HttpSession session, UUID idMisura ) throws Exception;

    List<MisuraModel> findMisuraBySensoreId ( HttpSession session, UUID idSensore ) throws Exception;
}
