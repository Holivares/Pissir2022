package edu.uniupo.pissir.service;

import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.UtenteAutenticazioneModel;
import edu.uniupo.pissir.model.UtenteModel;
import jakarta.servlet.http.HttpSession;

import java.util.UUID;

public interface UtenteService {

    UtenteModel createUtente ( HttpSession session, UtenteModel utenteModel ) throws Exception;

    UtenteModel updateUtente ( HttpSession session, UtenteModel utenteModel ) throws Exception;

    DeleteResponseModel deleteUtenteById ( HttpSession session, UUID idUtente ) throws Exception;

    UtenteModel findUtenteByEmailAndPassword ( HttpSession session, UtenteAutenticazioneModel utenteAutenticazioneModel ) throws Exception;

}
