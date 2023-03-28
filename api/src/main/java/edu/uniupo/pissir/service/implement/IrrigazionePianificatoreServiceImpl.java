package edu.uniupo.pissir.service.implement;

import edu.uniupo.pissir.entity.IrrigazionePianificatoreEntity;
import edu.uniupo.pissir.exception.NotFoundEntityException;
import edu.uniupo.pissir.mapper.ModelsToEntities;
import edu.uniupo.pissir.model.DefaultModel;
import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.IrrigazionePianificatoreModel;
import edu.uniupo.pissir.repository.IrrigazionePianificatoreRepository;
import edu.uniupo.pissir.service.IrrigazionePianificatoreService;
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
public class IrrigazionePianificatoreServiceImpl implements IrrigazionePianificatoreService {

    private final IrrigazionePianificatoreRepository irrigazionePianificatoreRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );
    private final Logger logger = LoggerFactory.getLogger( IrrigazionePianificatoreServiceImpl.class );

    @Autowired
    public IrrigazionePianificatoreServiceImpl ( IrrigazionePianificatoreRepository irrigazionePianificatoreRepository ) {
        this.irrigazionePianificatoreRepository = irrigazionePianificatoreRepository;
    }

    @Override
    public IrrigazionePianificatoreModel createIrrigazionePianificatore ( IrrigazionePianificatoreModel irrigazionePianificatoreModel ) throws Exception {
        logger.info( "The create irrigation planing method has been called ..." );
        DefaultModel.checkModelType( irrigazionePianificatoreModel, this.getClass().getName(), "createIrrigazionePianificatore" );
        IrrigazionePianificatoreEntity pianificatore =
                irrigazionePianificatoreRepository.save( mapper.modelToEntityOfIrrigazionePianificatore( irrigazionePianificatoreModel ) );
        return mapper.entityToModelOfIrrigazionePianificatore( pianificatore );
    }

    @Override
    public IrrigazionePianificatoreModel updateIrrigazionePianificatore ( IrrigazionePianificatoreModel irrigazionePianificatoreModel
                                                                        ) throws NotFoundEntityException {
        logger.info( "The update irrigation planing method has been called ..." );
        IrrigazionePianificatoreEntity oldIrrigazionePianificatore =
                OptionalUnpacker.unpackerOrThrows( irrigazionePianificatoreRepository.findById( irrigazionePianificatoreModel.getIdIrrigazionePianificatore() ),
                                                   "Not found data of this irrigation planning in server" );
        mapper.updateIrrigazionePianificatore( irrigazionePianificatoreModel, oldIrrigazionePianificatore );
        return mapper.entityToModelOfIrrigazionePianificatore( oldIrrigazionePianificatore );
    }

    @Override
    public DeleteResponseModel deleteIrrigazionePianificatoreById ( UUID idIrrigazionePianificatore ) throws Exception {
        logger.info( "The delete irrigation planing method has been called ..." );
        IrrigazionePianificatoreEntity irrigazionePianificatore =
                OptionalUnpacker.unpackerOrThrows( irrigazionePianificatoreRepository.findById( idIrrigazionePianificatore ),
                                                   "Not found data of this irrigation planning in server" );
        irrigazionePianificatoreRepository.deleteById( irrigazionePianificatore.getIdIrrigazionePianificatore() );
        return new DeleteResponseModel( "Piano irrigazione is deleted", true );
    }

    @Override
    public List<IrrigazionePianificatoreModel> findIrrigazionePianificatoreByIdAziendaAgricola ( UUID idAziendaAgricola ) throws Exception {
        logger.info( "The find irrigation planing by id of azienda agricola method has called ..." );
        List<IrrigazionePianificatoreEntity> irrigazionePianificatoreEntities =
                OptionalUnpacker.unpackerOrThrows( irrigazionePianificatoreRepository.findByAziendaAgricolaEntityIdAziendaAgricola( idAziendaAgricola ),
                                                   "This data for irrigation planing not existing in server" );
        return mapper.entityToModelListOfIrrigazionePianificatore( irrigazionePianificatoreEntities );
    }

    @Override
    public List<IrrigazionePianificatoreModel> findIrrigazionePianificatoreByIdserra ( UUID idSerra ) throws Exception {
        logger.info( "The find irrigation planing by id of serra method called ..." );
        List<IrrigazionePianificatoreEntity> irrigazionePianificatoreEntities =
                OptionalUnpacker.unpackerOrThrows( irrigazionePianificatoreRepository.findBySerraEntityIdSerra( idSerra ),
                                                   "This data for irrigation planing not existing in server" );
        return mapper.entityToModelListOfIrrigazionePianificatore( irrigazionePianificatoreEntities );
    }
}
