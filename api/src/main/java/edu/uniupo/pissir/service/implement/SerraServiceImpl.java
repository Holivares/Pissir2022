package edu.uniupo.pissir.service.implement;

import edu.uniupo.pissir.entity.SerraEntity;
import edu.uniupo.pissir.mapper.ModelsToEntities;
import edu.uniupo.pissir.model.DefaultModel;
import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.SerraModel;
import edu.uniupo.pissir.repository.SerraRepository;
import edu.uniupo.pissir.service.SerraService;
import edu.uniupo.pissir.utility.OptionalUnpacker;
import jakarta.servlet.http.HttpSession;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SerraServiceImpl implements SerraService {

    private final SerraRepository serraRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );
    private final Logger logger = LoggerFactory.getLogger( SerraServiceImpl.class );

    public SerraServiceImpl ( SerraRepository serraRepository ) {
        this.serraRepository = serraRepository;
    }

    @Override
    public SerraModel createSerra ( HttpSession session, SerraModel serraModel ) throws Exception {
        logger.info( "The create serra method has been called ..." );
        DefaultModel.checkModelType( serraModel, this.getClass().getName(), "createSerra" );
        SerraEntity serraEntity = serraRepository.save( mapper.modelToEntityOfSerra( serraModel ) );
        return mapper.entityToModelOfSerra( serraEntity );
    }

    @Override
    public SerraModel updateSerra ( HttpSession session, SerraModel serraModel ) throws Exception {
        logger.info( "The update serra method has been called ..." );
        DefaultModel.checkModelType( serraModel, this.getClass().getName(), "updateSerra" );
        SerraEntity oldSerra = OptionalUnpacker.unpackerOrThrows( serraRepository.findById( serraModel.getIdSerra() ),
                                                                  "Not found data of this serra in server" );
        mapper.updateSerraEntity( serraModel, oldSerra );
        return mapper.entityToModelOfSerra( oldSerra );
    }

    @Override
    public DeleteResponseModel deleteSerra ( HttpSession session, UUID idSerra ) throws Exception {
        logger.info( "The delete serra method has been called ..." );
        SerraEntity serraEntity = OptionalUnpacker.unpackerOrThrows( serraRepository.findById( idSerra ),
                                                                     "Not found data of this serra in server" );
        serraRepository.deleteById( serraEntity.getIdSerra() );
        return new DeleteResponseModel( "Serra is deleted", true );
    }

    @Override
    public List<SerraModel> findSerraByIdAziendaAgricola ( HttpSession session, UUID idAziendaAgricola ) throws Exception {
        logger.info( "The find serra with id of azienda method has been called ..." );
        List<SerraEntity> serre = OptionalUnpacker.unpackerOrThrows( serraRepository.findByAziendaAgricolaEntityIdAziendaAgricola( idAziendaAgricola ),
                                                                     "Have not found data of serra with the given id of azienda" );
        return mapper.entityToModelListOfSerra( serre );
    }
}
