package edu.uniupo.coltivazioni.service.implement;

import edu.uniupo.coltivazioni.entity.AttuatoreEntity;
import edu.uniupo.coltivazioni.entity.AttuatoreStatoEntity;
import edu.uniupo.coltivazioni.mapper.ModelsToEntities;
import edu.uniupo.coltivazioni.model.AttuatoreModel;
import edu.uniupo.coltivazioni.model.DefaultModel;
import edu.uniupo.coltivazioni.repository.AttuatoreRepository;
import edu.uniupo.coltivazioni.service.AttuatoreService;
import edu.uniupo.coltivazioni.utility.OptionalUnpacker;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AttuatoreServiceImpl implements AttuatoreService {

    private final AttuatoreRepository attuatoreRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );
    private final Logger logger = LoggerFactory.getLogger( AttuatoreServiceImpl.class );

    @Autowired
    public AttuatoreServiceImpl ( AttuatoreRepository attuatoreRepository ) {
        this.attuatoreRepository = attuatoreRepository;
    }

    @Override
    public AttuatoreModel createAttuatore ( AttuatoreModel attuatoreModel ) throws Exception {
        logger.info( "The create attuatore method has been called ..." );
        DefaultModel.checkModelType( attuatoreModel, AttuatoreServiceImpl.class.getName(), "createAttuatore" );
        AttuatoreEntity attuatoreEntity = attuatoreRepository.save( mapper.modelToEntityOfAttuatore( attuatoreModel ) );
        return mapper.entityToModelOfAttuatore( attuatoreEntity );

    }

    @Override
    public List<AttuatoreModel> findAttuatoreByIdSerra ( UUID idSerra ) throws Exception {
        logger.info( "The update attuatore method has been called..." );
        List<AttuatoreEntity> attuatoreEntityList = OptionalUnpacker.unpackerOrThrows( attuatoreRepository.findBySerraEntityIdSerra( idSerra ), "Not found data " +
                                                                                                                                                "of this " +
                                                                                                                                                "attuatore in " +
                                                                                                                                                "server" );
        return mapper.entityToModelListOfAttuatore( attuatoreEntityList );
    }

    @Override
    public AttuatoreModel enableAttuatore ( UUID idAttuatore ) throws Exception {
        logger.info( "The enable attuatore method has been called..." );
        AttuatoreEntity attuatoreEntity = OptionalUnpacker.unpackerOrThrows( attuatoreRepository.findById( idAttuatore ), "Not found data of this attuatore in " +
                                                                                                                          "server" );
        attuatoreEntity.getStato().setStato( AttuatoreStatoEntity.ATTIVO );
        return mapper.entityToModelOfAttuatore( attuatoreEntity );
    }

    @Override
    public AttuatoreModel disableAttuatore ( UUID idAttuatore ) throws Exception {
        logger.info( "The disable attuatore method has been called..." );
        AttuatoreEntity attuatoreEntity = OptionalUnpacker.unpackerOrThrows( attuatoreRepository.findById( idAttuatore ), "Not found data of this attuatore in " +
                                                                                                                          "server" );
        attuatoreEntity.getStato().setStato( AttuatoreStatoEntity.DISATTIVATO );
        return mapper.entityToModelOfAttuatore( attuatoreEntity );
    }

}
