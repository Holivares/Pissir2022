package edu.uniupo.pissir.service.implement;

import edu.uniupo.pissir.entity.AziendaAgricolaEntity;
import edu.uniupo.pissir.exception.DuplicateEntityException;
import edu.uniupo.pissir.mapper.ModelsToEntities;
import edu.uniupo.pissir.model.AziendaAgricolaModel;
import edu.uniupo.pissir.model.DefaultModel;
import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.repository.AziendaAgricolaRepository;
import edu.uniupo.pissir.service.AziendaAgricolaService;
import edu.uniupo.pissir.service.thrower.ServiceThrower;
import edu.uniupo.pissir.utility.OptionalUnpacker;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class AziendaAgricolaServiceImpl implements AziendaAgricolaService {
    private final AziendaAgricolaRepository aziendaAgricolaRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );

    private final ServiceThrower<Exception> serviceThrower = ( exception ) -> {throw exception;};
    private final Logger logger = LoggerFactory.getLogger( AziendaAgricolaServiceImpl.class );

    @Autowired
    public AziendaAgricolaServiceImpl ( AziendaAgricolaRepository aziendaAgricolaRepository ) {
        this.aziendaAgricolaRepository = aziendaAgricolaRepository;
    }

    @Override
    public AziendaAgricolaModel createAziendaAgricola ( AziendaAgricolaModel aziendaAgricolaModel ) throws Exception {
        logger.info( "The create aziendaAgricola method has been called ..." );
        DefaultModel.checkModelType( aziendaAgricolaModel, this.getClass().getName(), "createAziendaAgricola" );
        AziendaAgricolaEntity aziendaAgricola = OptionalUnpacker.unpacker( aziendaAgricolaRepository
                                                                                   .findByUtenteEntityIdUtente( aziendaAgricolaModel.getIdUtente() ) );
        if( aziendaAgricola != null ) {
            serviceThrower.thrower( new DuplicateEntityException( this.getClass().getName(), "createAziendaAgricola", "This user have already an azienda" ) );
        }
        AziendaAgricolaEntity azienda = aziendaAgricolaRepository.save( mapper.modelToEntityOfAziendaAgricola( aziendaAgricolaModel ) );
        return mapper.entityToModelOfAziendaAgricola( azienda );
    }

    @Override
    public AziendaAgricolaModel updateAziendaAgricola ( AziendaAgricolaModel aziendaAgricolaModel ) throws Exception {
        logger.info( "The update aziendaAgricola method has been called ..." );
        DefaultModel.checkModelType( aziendaAgricolaModel, this.getClass().getName(), "updateAziendaAgricola" );
        AziendaAgricolaEntity oldAziendaAgricola =
                OptionalUnpacker.unpackerOrThrows( aziendaAgricolaRepository.findById( aziendaAgricolaModel.getIdAziendaAgricola() ),
                                                   "Not found data of this azienda in server" );
        mapper.updateAziendaAgricolaEntity( aziendaAgricolaModel, oldAziendaAgricola );
        return mapper.entityToModelOfAziendaAgricola( oldAziendaAgricola );
    }

    @Override
    public DeleteResponseModel deleteAziendaAgricola ( UUID idAziendaAgricola ) throws Exception {
        logger.info( "The delete aziendaAgricola method has been called ..." );
        AziendaAgricolaEntity aziendaAgricola = OptionalUnpacker.unpackerOrThrows( aziendaAgricolaRepository.findById( idAziendaAgricola ),
                                                                                   "Not found data of this azienda in server" );
        aziendaAgricolaRepository.deleteById( aziendaAgricola.getIdAziendaAgricola() );
        return new DeleteResponseModel( "Azienda Agricola is deleted", true );
    }

    @Override
    public AziendaAgricolaModel findAziendaAgricolaByIdUser ( UUID idUtente ) throws Exception {
        logger.info( "The find aziendaAgricola by id of user method has been called ..." );
        AziendaAgricolaEntity aziendaAgricola = OptionalUnpacker.unpackerOrThrows( aziendaAgricolaRepository.findByUtenteEntityIdUtente( idUtente ),
                                                                                   "Not found data of this azienda in server" );
        return mapper.entityToModelOfAziendaAgricola( aziendaAgricola );
    }

    @Override
    public AziendaAgricolaModel findAziendaAgricolaById ( UUID idAziendaAgricola ) throws Exception {
        logger.info( "The find aziendaAgricola with his id method has been called ..." );
        AziendaAgricolaEntity aziendaAgricola = OptionalUnpacker.unpackerOrThrows( aziendaAgricolaRepository.findById( idAziendaAgricola ),
                                                                                   "Not found data of this azienda in server" );
        return mapper.entityToModelOfAziendaAgricola( aziendaAgricola );
    }

    @Override
    public AziendaAgricolaModel findAziendaAgricolaByName ( String nome ) throws Exception {
        logger.info( "The find aziendaAgricola with his name method has been called ..." );
        AziendaAgricolaEntity aziendaAgricola = OptionalUnpacker.unpackerOrThrows( aziendaAgricolaRepository.findByNome( nome ),
                                                                                   "Not found data of this azienda in server" );
        return mapper.entityToModelOfAziendaAgricola( aziendaAgricola );
    }
}
