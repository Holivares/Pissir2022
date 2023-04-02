package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.AttuatoreModel;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.UUID;

public interface AttuatoreService {

    AttuatoreModel createAttuatore ( HttpSession session, AttuatoreModel attuatoreModel ) throws Exception;

    List<AttuatoreModel> findAttuatoreByIdSerra ( HttpSession session, UUID idSerra ) throws Exception;

    AttuatoreModel enableAttuatore ( HttpSession session, UUID idAttuatore ) throws Exception;

    AttuatoreModel disableAttuatore ( HttpSession session, UUID idAttuatore ) throws Exception;
}
