package edu.uniupo.coltivazioni.service.implement;

import edu.uniupo.coltivazioni.entity.AttuatoreEntity;
import edu.uniupo.coltivazioni.entity.AttuatoreStatoEntity;
import edu.uniupo.coltivazioni.mapper.ModelsToEntities;
import edu.uniupo.coltivazioni.model.AttuatoreModel;
import edu.uniupo.coltivazioni.repository.AttuatoreRepository;
import edu.uniupo.coltivazioni.service.AttuatoreService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AttuatoreServiceImpl implements AttuatoreService {

    private final AttuatoreRepository attuatoreRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );

    @Autowired
    public AttuatoreServiceImpl ( AttuatoreRepository attuatoreRepository ) {
        this.attuatoreRepository = attuatoreRepository;
    }

    @Override
    public AttuatoreModel createAttuatore ( AttuatoreModel attuatoreModel ) {
        AttuatoreEntity attuatoreEntity = attuatoreRepository.save( mapper.modelToEntityOfAttuatore( attuatoreModel ) );
        return mapper.entityToModelOfAttuatore( attuatoreEntity );

    }

    @Override
    public AttuatoreModel findAttuatoreByIdSerra ( UUID idSerra ) {
        Optional<AttuatoreEntity> attuatore = attuatoreRepository.findBySerraEntityIdSerra( idSerra );
        return mapper.entityToModelOfAttuatore( attuatore.orElse( new AttuatoreEntity() ) );
    }

    @Override
    public AttuatoreModel enableAttuatore ( UUID idAttuatore ) {
        Optional<AttuatoreEntity> attuatore = attuatoreRepository.findById( idAttuatore );
        attuatore.ifPresent( entity -> entity.getStato().setStato( AttuatoreStatoEntity.ATTIVO ) );
        return mapper.entityToModelOfAttuatore( attuatore.orElse( new AttuatoreEntity() ) );
    }

    @Override
    public AttuatoreModel disableAttuatore ( UUID idAttuatore ) {
        Optional<AttuatoreEntity> attuatore = attuatoreRepository.findById( idAttuatore );
        attuatore.ifPresent( entity -> entity.getStato().setStato( AttuatoreStatoEntity.DISATTIVATO ) );
        return mapper.entityToModelOfAttuatore( attuatore.orElse( new AttuatoreEntity() ) );
    }

}
