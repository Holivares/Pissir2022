package edu.uniupo.coltivazioni.service.implement;

import edu.uniupo.coltivazioni.entity.SerraEntity;
import edu.uniupo.coltivazioni.mapper.ModelsToEntities;
import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.model.SerraModel;
import edu.uniupo.coltivazioni.repository.SerraRepository;
import edu.uniupo.coltivazioni.service.SerraService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class SerraServiceImpl implements SerraService {

    private final SerraRepository serraRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );

    public SerraServiceImpl ( SerraRepository serraRepository ) {
        this.serraRepository = serraRepository;
    }

    @Override
    public SerraModel createSerra ( SerraModel serraModel ) {
        SerraEntity serraEntity = serraRepository.save( mapper.modelToEntityOfSerra( serraModel ) );
        return mapper.entityToModelOfSerra( serraEntity );
    }

    @Override
    public SerraModel updateSerra ( SerraModel serraModel ) {
        SerraEntity serraEntity = serraRepository.save( mapper.modelToEntityOfSerra( serraModel ) );
        return mapper.entityToModelOfSerra( serraEntity );
    }

    @Override
    public DeleteResponseModel deleteSerra ( UUID idSerra ) {
        serraRepository.deleteById( idSerra );
        return new DeleteResponseModel( "Serra is deleted", true );
    }

    @Override
    public SerraModel findSerraByIdAziendaAgricola ( UUID idAziendaAgricola ) {
        Optional<SerraEntity> serra = serraRepository.findByAziendaAgricolaEntityIdAziendaAgricola( idAziendaAgricola );
        return mapper.entityToModelOfSerra( serra.orElse( new SerraEntity() ) );
    }
}
