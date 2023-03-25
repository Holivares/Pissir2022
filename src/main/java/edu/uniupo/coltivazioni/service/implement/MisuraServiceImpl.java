package edu.uniupo.coltivazioni.service.implement;

import edu.uniupo.coltivazioni.entity.MisuraEntity;
import edu.uniupo.coltivazioni.mapper.ModelsToEntities;
import edu.uniupo.coltivazioni.model.MisuraModel;
import edu.uniupo.coltivazioni.repository.MisuraRepository;
import edu.uniupo.coltivazioni.service.MisuraService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class MisuraServiceImpl implements MisuraService {

    private final MisuraRepository misuraRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );

    @Autowired
    public MisuraServiceImpl ( MisuraRepository misuraRepository ) {
        this.misuraRepository = misuraRepository;
    }

    @Override
    public MisuraModel createMisura ( MisuraModel misuraModel ) {
        MisuraEntity misuraEntity = misuraRepository.save( mapper.modelToEntityOfMisura( misuraModel ) );
        return mapper.entityToModelOfMisura( misuraEntity );
    }

    @Override
    public MisuraModel findMisuraById ( UUID idMisura ) {
        Optional<MisuraEntity> misura = misuraRepository.findById( idMisura );
        return mapper.entityToModelOfMisura( misura.orElse( new MisuraEntity() ) );
    }

    @Override
    public MisuraModel findMisuraBySensoreId ( UUID idSensore ) {
        Optional<MisuraEntity> misura = misuraRepository.findBySensoreEntityIdSensore( idSensore );
        return mapper.entityToModelOfMisura( misura.orElse( new MisuraEntity() ) );
    }
}
