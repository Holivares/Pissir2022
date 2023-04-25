package edu.uniupo.pissir.service.implement;

import edu.uniupo.pissir.entity.AttuatoreEntity;
import edu.uniupo.pissir.entity.AttuatoreModeEntity;
import edu.uniupo.pissir.entity.AttuatoreStatoEntity;
import edu.uniupo.pissir.exception.NotFoundEntityException;
import edu.uniupo.pissir.mapper.ModelsToEntities;
import edu.uniupo.pissir.model.AttuatoreModel;
import edu.uniupo.pissir.model.DefaultModel;
import edu.uniupo.pissir.repository.AttuatoreRepository;
import edu.uniupo.pissir.service.AttuatoreService;
import edu.uniupo.pissir.utility.OptionalUnpacker;
import jakarta.servlet.http.HttpSession;
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
    public AttuatoreModel createAttuatore ( HttpSession session, AttuatoreModel attuatoreModel ) throws Exception {
        logger.info( "The create attuatore method has been called ..." );
        DefaultModel.checkModelType( attuatoreModel, AttuatoreServiceImpl.class.getName(), "createAttuatore" );
        AttuatoreEntity attuatoreEntity = attuatoreRepository.save( mapper.modelToEntityOfAttuatore( attuatoreModel ) );
        return mapper.entityToModelOfAttuatore( attuatoreEntity );

    }

    @Override
    public List<AttuatoreModel> findAttuatoreByIdSerra ( HttpSession session, UUID idSerra ) throws Exception {
        logger.info( "The update attuatore method has been called..." );
        List<AttuatoreEntity> attuatoreEntityList = OptionalUnpacker.unpackerOrThrows( attuatoreRepository.findBySerraEntityIdSerra( idSerra ), "Not found data " +
                                                                                                                                                "of this " +
                                                                                                                                                "attuatore in " +
                                                                                                                                                "server" );
        return mapper.entityToModelListOfAttuatore( attuatoreEntityList );
    }

    @Override
    public AttuatoreModel enableAttuatore ( HttpSession session, UUID idAttuatore ) throws Exception {
        logger.info( "The enable attuatore method has been called..." );
        AttuatoreEntity attuatoreEntity = OptionalUnpacker.unpackerOrThrows( attuatoreRepository.findById( idAttuatore ), "Not found data of this attuatore in " +
                                                                                                                          "server" );
        attuatoreEntity.getStato().setStato( AttuatoreStatoEntity.ATTIVO );
        return mapper.entityToModelOfAttuatore( attuatoreEntity );
    }

    @Override
    public AttuatoreModel disableAttuatore ( HttpSession session, UUID idAttuatore ) throws Exception {
        logger.info( "The disable attuatore method has been called..." );
        AttuatoreEntity attuatoreEntity = OptionalUnpacker.unpackerOrThrows( attuatoreRepository.findById( idAttuatore ), "Not found data of this attuatore in " +
                                                                                                                          "server" );
        attuatoreEntity.getStato().setStato( AttuatoreStatoEntity.DISATTIVATO );
        return mapper.entityToModelOfAttuatore( attuatoreEntity );
    }

    @Override
    public AttuatoreModel getManualModeAttuatore ( HttpSession session, UUID idAttuatore ) throws Exception {
        logger.info( "The get mode manual of attuatore method has been called..." );
        AttuatoreEntity attuatoreEntity = OptionalUnpacker.unpackerOrThrows( attuatoreRepository.findById( idAttuatore ), "Not found data of this attuatore in " +
                                                                                                                          "server" );
        attuatoreEntity.getStato().setMode( AttuatoreModeEntity.MANUALE);
        return mapper.entityToModelOfAttuatore( attuatoreEntity );
    }

    @Override
    public AttuatoreModel getAutomatiqueModeAttuatore ( HttpSession session, UUID idAttuatore ) throws Exception {
        logger.info( "The get mode automatique of attuatore method has been called..." );
        AttuatoreEntity attuatoreEntity = OptionalUnpacker.unpackerOrThrows( attuatoreRepository.findById( idAttuatore ), "Not found data of this attuatore in " +
                                                                                                                          "server" );
        attuatoreEntity.getStato().setMode( AttuatoreModeEntity.AUTOMATICO );
        return mapper.entityToModelOfAttuatore( attuatoreEntity );
    }

}
