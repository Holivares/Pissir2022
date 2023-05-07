package edu.uniupo.pissir.service.implement;

import edu.uniupo.pissir.entity.SensoreEntity;
import edu.uniupo.pissir.mapper.ModelsToEntities;
import edu.uniupo.pissir.model.DefaultModel;
import edu.uniupo.pissir.model.SensoreModel;
import edu.uniupo.pissir.repository.SensoreRepository;
import edu.uniupo.pissir.service.MisuraService;
import edu.uniupo.pissir.service.SensoreService;
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
public class SensoreServiceImpl implements SensoreService {

    private final SensoreRepository sensoreRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );

    private final MisuraService misuraService;
    private final Logger logger = LoggerFactory.getLogger( SensoreServiceImpl.class );

    public SensoreServiceImpl ( SensoreRepository sensoreRepository, MisuraService misuraService ) {
        this.sensoreRepository = sensoreRepository;
        this.misuraService = misuraService;
    }

    @Override
    public SensoreModel createSensore ( HttpSession session, SensoreModel sensoreModel ) throws Exception {
        logger.info( "The create sensore method has been called ..." );
        DefaultModel.checkModelType( sensoreModel, this.getClass().getName(), "createSensore" );
        SensoreEntity sensoreEntity = sensoreRepository.save( mapper.modelToEntityOfSensore( sensoreModel ) );
        return mapper.entityToModelOfSensore( sensoreEntity );
    }

    @Override
    public List<SensoreModel> findSensoreByIdSerra ( HttpSession session, UUID idSerra ) throws Exception {
        logger.info( "The find sensore by id serra method has been called ..." );
        List<SensoreEntity> sensore = OptionalUnpacker.unpackerOrThrows( sensoreRepository.findBySerraEntityIdSerra( idSerra ),
                                                                         "Have not found data of sensore with the given id of serra" );
        return mapper.entityToModelListOfSensore( sensore );
    }

    @Override
    public void deleteSensoreByIdSensore ( HttpSession session, UUID idSensore ) throws Exception {
        logger.info( "Delete sensore by id sensore method has been called ..." );
        misuraService.deleteAllMisura(session, idSensore);
        sensoreRepository.delete( OptionalUnpacker.unpacker( sensoreRepository.findById( idSensore ) ) );
    }
}
