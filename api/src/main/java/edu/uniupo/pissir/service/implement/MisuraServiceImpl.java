package edu.uniupo.pissir.service.implement;

import edu.uniupo.pissir.entity.MisuraEntity;
import edu.uniupo.pissir.mapper.ModelsToEntities;
import edu.uniupo.pissir.model.DefaultModel;
import edu.uniupo.pissir.model.MisuraModel;
import edu.uniupo.pissir.repository.MisuraRepository;
import edu.uniupo.pissir.service.MisuraService;
import edu.uniupo.pissir.utility.OptionalUnpacker;
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
public class MisuraServiceImpl implements MisuraService {

    private final MisuraRepository misuraRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );
    private final Logger logger = LoggerFactory.getLogger( MisuraServiceImpl.class );

    @Autowired
    public MisuraServiceImpl ( MisuraRepository misuraRepository ) {
        this.misuraRepository = misuraRepository;
    }

    @Override
    public MisuraModel createMisura ( MisuraModel misuraModel ) throws Exception {
        logger.info( "The find misura by his id method has been called ..." );
        DefaultModel.checkModelType( misuraModel, this.getClass().getName(), "createMisura" );
        MisuraEntity misuraEntity = misuraRepository.save( mapper.modelToEntityOfMisura( misuraModel ) );
        return mapper.entityToModelOfMisura( misuraEntity );
    }

    @Override
    public MisuraModel findMisuraById ( UUID idMisura ) throws Exception {
        logger.info( "The find misura by his id method has been called ..." );
        MisuraEntity misura = OptionalUnpacker.unpackerOrThrows( misuraRepository.findById( idMisura ),
                                                                 "Have not found data of misura with the given id" );
        return mapper.entityToModelOfMisura( misura );
    }

    @Override
    public List<MisuraModel> findMisuraBySensoreId ( UUID idSensore ) throws Exception {
        logger.info( "The find misura by id sensore method has been called ..." );
        List<MisuraEntity> misura = OptionalUnpacker.unpackerOrThrows( misuraRepository.findBySensoreEntityIdSensore( idSensore ),
                                                                       "Have not found data of misura with the given id of sensore" );
        return mapper.entityToModelListOfMisura( misura );
    }
}
