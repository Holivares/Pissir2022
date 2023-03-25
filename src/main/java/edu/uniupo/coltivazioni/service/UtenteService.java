package edu.uniupo.coltivazioni.service;

import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.model.ModelType;
import edu.uniupo.coltivazioni.model.UtenteAutenticazioneModel;
import edu.uniupo.coltivazioni.model.UtenteModel;
import edu.uniupo.coltivazioni.service.thrower.ServiceThrower;

import java.util.UUID;

public interface UtenteService {

    ServiceThrower<Exception> serviceThrower = ( invalidModelException ) -> {throw invalidModelException;};

    UtenteModel createUtente ( UtenteModel utenteModel ) throws Exception;

    UtenteModel updateUtente ( UtenteModel utenteModel ) throws Exception;

    DeleteResponseModel deleteUtenteById ( UUID idUtente ) throws Exception;

    UtenteModel findUtenteByEmailAndPassword ( UtenteAutenticazioneModel utenteAutenticazioneModel ) throws Exception;

    default <T extends ModelType> void checkUtenteModel ( T t ) throws Exception {
        T.isNull( t, serviceThrower, this.getClass().getName(), "createUtente" );
        t.validate( serviceThrower, this.getClass().getName(), "createUtente" );
    }

}
