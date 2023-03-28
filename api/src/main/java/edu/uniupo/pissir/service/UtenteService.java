package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.UtenteAutenticazioneModel;
import edu.uniupo.pissir.model.UtenteModel;

import java.util.UUID;

public interface UtenteService {

    UtenteModel createUtente ( UtenteModel utenteModel ) throws Exception;

    UtenteModel updateUtente ( UtenteModel utenteModel ) throws Exception;

    DeleteResponseModel deleteUtenteById ( UUID idUtente ) throws Exception;

    UtenteModel findUtenteByEmailAndPassword ( UtenteAutenticazioneModel utenteAutenticazioneModel ) throws Exception;

}
