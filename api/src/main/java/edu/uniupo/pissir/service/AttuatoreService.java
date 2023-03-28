package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.AttuatoreModel;

import java.util.List;
import java.util.UUID;

public interface AttuatoreService {

    AttuatoreModel createAttuatore ( AttuatoreModel attuatoreModel ) throws Exception;

    List<AttuatoreModel> findAttuatoreByIdSerra ( UUID idSerra ) throws Exception;

    AttuatoreModel enableAttuatore ( UUID idAttuatore ) throws Exception;

    AttuatoreModel disableAttuatore ( UUID idAttuatore ) throws Exception;
}
