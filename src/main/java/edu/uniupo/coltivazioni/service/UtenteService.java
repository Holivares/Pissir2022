package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.model.UtenteAutenticazioneModel;
import edu.uniupo.coltivazioni.model.UtenteModel;

import java.util.UUID;

public interface UtenteService {

    UtenteModel createUtente ( UtenteModel utenteModel ) throws Exception;

    UtenteModel updateUtente ( UtenteModel utenteModel ) throws Exception;

    DeleteResponseModel deleteUtenteById ( UUID idUtente ) throws Exception;

    UtenteModel findUtenteByEmailAndPassword ( UtenteAutenticazioneModel utenteAutenticazioneModel ) throws Exception;

}
