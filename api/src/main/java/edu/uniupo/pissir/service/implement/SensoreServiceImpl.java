package edu.uniupo.pissir.service.implement;

import edu.uniupo.pissir.entity.SensoreEntity;
import edu.uniupo.pissir.mapper.ModelsToEntities;
import edu.uniupo.pissir.model.DefaultModel;
import edu.uniupo.pissir.model.SensoreModel;
import edu.uniupo.pissir.repository.SensoreRepository;
import edu.uniupo.pissir.service.SensoreService;
import edu.uniupo.pissir.utility.OptionalUnpacker;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SensoreServiceImpl implements SensoreService {

    private final SensoreRepository sensoreRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );
    private final Logger logger = LoggerFactory.getLogger( SensoreServiceImpl.class );

    public SensoreServiceImpl ( SensoreRepository sensoreRepository ) {
        this.sensoreRepository = sensoreRepository;
    }

    @Override
    public SensoreModel createSensore ( SensoreModel sensoreModel ) throws Exception {
        logger.info( "The create sensore method has been called ..." );
        DefaultModel.checkModelType( sensoreModel, this.getClass().getName(), "createSensore" );
        SensoreEntity sensoreEntity = sensoreRepository.save( mapper.modelToEntityOfSensore( sensoreModel ) );
        return mapper.entityToModelOfSensore( sensoreEntity );
    }

    @Override
    public List<SensoreModel> findSensoreByIdSerra ( UUID idSerra ) throws Exception {
        logger.info( "The find sensore by id serra method has been called ..." );
        List<SensoreEntity> sensore = OptionalUnpacker.unpackerOrThrows( sensoreRepository.findBySerraEntityIdSerra( idSerra ),
                                                                         "Have not found data of sensore with the given id of serra" );
        return mapper.entityToModelListOfSensore( sensore );
    }
}
