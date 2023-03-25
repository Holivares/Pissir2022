package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.AttuatoreModel;

import java.util.UUID;

public interface AttuatoreService {

    AttuatoreModel createAttuatore ( AttuatoreModel attuatoreModel );

    AttuatoreModel findAttuatoreByIdSerra ( UUID idSerra );

    AttuatoreModel enableAttuatore ( UUID idAttuatore );

    AttuatoreModel disableAttuatore ( UUID idAttuatore );
}
