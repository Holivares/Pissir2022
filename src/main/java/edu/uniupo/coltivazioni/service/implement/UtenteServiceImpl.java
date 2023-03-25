package edu.uniupo.coltivazioni.service.implement;

import edu.uniupo.coltivazioni.entity.UtenteEntity;
import edu.uniupo.coltivazioni.mapper.ModelsToEntities;
import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.model.UtenteAutenticazioneModel;
import edu.uniupo.coltivazioni.model.UtenteModel;
import edu.uniupo.coltivazioni.repository.UtenteRepository;
import edu.uniupo.coltivazioni.service.UtenteService;
import edu.uniupo.coltivazioni.utility.OptionalUnpacker;
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
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );
    private final Logger logger = LoggerFactory.getLogger( UtenteServiceImpl.class );

    public UtenteServiceImpl ( UtenteRepository utenteRepository ) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public UtenteModel createUtente ( UtenteModel utenteModel ) throws Exception {
        logger.info( "The create user method has been called ..." );
        checkUtenteModel( utenteModel );
        UtenteEntity utenteEntity = utenteRepository.save( mapper.modelToEntityOfUtente( utenteModel ) );
        return mapper.entityToModelOfUtente( utenteEntity );
    }

    @Override
    public UtenteModel updateUtente ( UtenteModel utenteModel ) throws Exception {
        logger.info( "The update user method has been called ..." );
        checkUtenteModel( utenteModel );
        UtenteEntity oldUtente = OptionalUnpacker.unpacker( utenteRepository.findById( utenteModel.getIdUtente() ), "Not found data in server" );
        mapper.updateEntity( utenteModel, oldUtente );
        return mapper.entityToModelOfUtente( oldUtente );
    }

    @Override
    public DeleteResponseModel deleteUtenteById ( UUID idUtente ) throws Exception {
        logger.info( "The delete user method has been called ..." );
        UtenteEntity utente = OptionalUnpacker.unpacker( utenteRepository.findById( idUtente ), "Not found data in server" );
        utenteRepository.deleteById( utente.getIdUtente() );
        return new DeleteResponseModel( "Utente is deleted", true );
    }

    @Override
    public UtenteModel findUtenteByEmailAndPassword ( UtenteAutenticazioneModel utenteAutenticazioneModel ) throws Exception {
        logger.info( "The find user by email and password method has been called ..." );
        checkUtenteModel( utenteAutenticazioneModel );
        UtenteEntity utente = OptionalUnpacker.unpacker( utenteRepository.findByEmail( utenteAutenticazioneModel.getEmail() ), "Authentication has failed" );
        return mapper.entityToModelOfUtente( utente );
    }
}
