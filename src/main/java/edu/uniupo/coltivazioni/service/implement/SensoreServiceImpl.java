package edu.uniupo.coltivazioni.service.implement;

import edu.uniupo.coltivazioni.entity.SensoreEntity;
import edu.uniupo.coltivazioni.mapper.ModelsToEntities;
import edu.uniupo.coltivazioni.model.SensoreModel;
import edu.uniupo.coltivazioni.repository.SensoreRepository;
import edu.uniupo.coltivazioni.service.SensoreService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class SensoreServiceImpl implements SensoreService {

    private final SensoreRepository sensoreRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );

    public SensoreServiceImpl ( SensoreRepository sensoreRepository ) {
        this.sensoreRepository = sensoreRepository;
    }

    @Override
    public SensoreModel createSensore ( SensoreModel sensoreModel ) {
        SensoreEntity sensoreEntity = sensoreRepository.save( mapper.modelToEntityOfSensore( sensoreModel ) );
        return mapper.entityToModelOfSensore( sensoreEntity );
    }

    @Override
    public SensoreModel findSensoreByIdSerra ( UUID idSerra ) {
        Optional<SensoreEntity> sensore = sensoreRepository.findBySerraEntityIdSerra( idSerra );
        return mapper.entityToModelOfSensore( sensore.orElse( new SensoreEntity() ) );
    }
}
