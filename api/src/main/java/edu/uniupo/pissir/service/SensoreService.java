package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.SensoreModel;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.UUID;

public interface SensoreService {
    SensoreModel createSensore ( HttpSession session, SensoreModel sensoreModel ) throws Exception;

    List<SensoreModel> findSensoreByIdSerra ( HttpSession session, UUID idSerra ) throws Exception;
}
