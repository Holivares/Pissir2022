package edu.uniupo.pissir.service.implement;

import edu.uniupo.pissir.entity.UtenteEntity;
import edu.uniupo.pissir.exception.NotFoundEntityException;
import edu.uniupo.pissir.mapper.ModelsToEntities;
import edu.uniupo.pissir.model.DefaultModel;
import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.UtenteAutenticazioneModel;
import edu.uniupo.pissir.model.UtenteModel;
import edu.uniupo.pissir.repository.UtenteRepository;
import edu.uniupo.pissir.service.IotConnectionService;
import edu.uniupo.pissir.service.UtenteService;
import edu.uniupo.pissir.service.thrower.ServiceThrower;
import edu.uniupo.pissir.utility.OptionalUnpacker;
import jakarta.servlet.http.HttpSession;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UtenteServiceImpl implements UtenteService {

    private final UtenteRepository utenteRepository;
    private final IotConnectionService iotConnectionService;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );
    private final ServiceThrower<Exception> serviceThrower = ( exception ) -> {throw exception;};
    private final Logger logger = LoggerFactory.getLogger( UtenteServiceImpl.class );

    public UtenteServiceImpl ( UtenteRepository utenteRepository, IotConnectionService iotConnectionService ) {
        this.utenteRepository = utenteRepository;
        this.iotConnectionService = iotConnectionService;
    }

    @Override
    public UtenteModel createUtente ( HttpSession session, UtenteModel utenteModel ) throws Exception {
        logger.info( "The create user method has been called ..." );
        DefaultModel.checkModelType( utenteModel, this.getClass().getName(), "createUtente" );
        UtenteEntity utenteEntity = utenteRepository.save( mapper.modelToEntityOfUtente( utenteModel ) );
        return mapper.entityToModelOfUtente( utenteEntity );
    }

    @Override
    public UtenteModel updateUtente ( HttpSession session, UtenteModel utenteModel ) throws Exception {
        logger.info( "The update user method has been called ..." );
        DefaultModel.checkModelType( utenteModel, this.getClass().getName(), "updateUtente" );
        UtenteEntity oldUtente = OptionalUnpacker.unpackerOrThrows( utenteRepository.findById( utenteModel.getIdUtente() ),
                                                                    "Not found data of this utente in server" );
        mapper.updateUtenteEntity( utenteModel, oldUtente );
        return mapper.entityToModelOfUtente( oldUtente );
    }

    @Override
    public DeleteResponseModel deleteUtenteById ( HttpSession session, UUID idUtente ) throws Exception {
        logger.info( "The delete user method has been called ..." );
        UtenteEntity utente = OptionalUnpacker.unpackerOrThrows( utenteRepository.findById( idUtente ),
                                                                 "Not found data of this utente in server" );
        utenteRepository.deleteById( utente.getIdUtente() );
        return new DeleteResponseModel( "Utente is deleted", true );
    }

    @Override
    public UtenteModel findUtenteByEmailAndPassword ( HttpSession session, UtenteAutenticazioneModel utenteAutenticazioneModel ) throws Exception {
        logger.info( "The find user by email and password method has been called ..." );
        DefaultModel.checkModelType( utenteAutenticazioneModel, this.getClass().getName(), "findUtenteByEmailAndPassword" );
        UtenteEntity utente = OptionalUnpacker.unpackerOrThrows( utenteRepository.findByEmail( utenteAutenticazioneModel.getEmail() ),
                                                                 "Authentication has failed" );
        if( !utente.getPassword().equals( utenteAutenticazioneModel.getPassword() ) ) {
            serviceThrower.thrower( new NotFoundEntityException( this.getClass().getName(), "findUtenteByEmailAndPassword", "Authentication has failed" ) );
        }

        session.setAttribute( "role", utente.getRole().toString() );
        iotConnectionService.getConnection( utente );
        return mapper.entityToModelOfUtente( utente );
    }
}
