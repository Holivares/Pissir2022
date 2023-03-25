package edu.uniupo.coltivazioni.service.implement;

import edu.uniupo.coltivazioni.entity.SerraEntity;
import edu.uniupo.coltivazioni.mapper.ModelsToEntities;
import edu.uniupo.coltivazioni.model.DefaultModel;
import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.model.SerraModel;
import edu.uniupo.coltivazioni.repository.SerraRepository;
import edu.uniupo.coltivazioni.service.SerraService;
import edu.uniupo.coltivazioni.utility.OptionalUnpacker;
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
    public SerraModel createSerra ( SerraModel serraModel ) throws Exception {
        logger.info( "The create serra method has been called ..." );
        DefaultModel.checkModelType( serraModel, this.getClass().getName(), "createSerra" );
        SerraEntity serraEntity = serraRepository.save( mapper.modelToEntityOfSerra( serraModel ) );
        return mapper.entityToModelOfSerra( serraEntity );
    }

    @Override
    public SerraModel updateSerra ( SerraModel serraModel ) throws Exception {
        logger.info( "The update serra method has been called ..." );
        DefaultModel.checkModelType( serraModel, this.getClass().getName(), "updateSerra" );
        SerraEntity oldSerra = OptionalUnpacker.unpackerOrThrows( serraRepository.findById( serraModel.getIdSerra() ),
                                                                  "Not found data of this serra in server" );
        mapper.updateSerraEntity( serraModel, oldSerra );
        return mapper.entityToModelOfSerra( oldSerra );
    }

    @Override
    public DeleteResponseModel deleteSerra ( UUID idSerra ) throws Exception {
        logger.info( "The delete serra method has been called ..." );
        SerraEntity serraEntity = OptionalUnpacker.unpackerOrThrows( serraRepository.findById( idSerra ),
                                                                     "Not found data of this serra in server" );
        serraRepository.deleteById( serraEntity.getIdSerra() );
        return new DeleteResponseModel( "Serra is deleted", true );
    }

    @Override
    public List<SerraModel> findSerraByIdAziendaAgricola ( UUID idAziendaAgricola ) throws Exception {
        logger.info( "The find serra with id of azienda method has been called ..." );
        List<SerraEntity> serre = OptionalUnpacker.unpackerOrThrows( serraRepository.findByAziendaAgricolaEntityIdAziendaAgricola( idAziendaAgricola ),
                                                                     "Have not found data of serra with the given id of azienda" );
        return mapper.entityToModelListOfSerra( serre );
    }
}
