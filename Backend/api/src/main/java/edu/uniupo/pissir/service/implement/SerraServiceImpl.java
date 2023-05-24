package edu.uniupo.pissir.service.implement;

import edu.uniupo.pissir.entity.SerraEntity;
import edu.uniupo.pissir.mapper.ModelsToEntities;
import edu.uniupo.pissir.model.*;
import edu.uniupo.pissir.repository.SerraRepository;
import edu.uniupo.pissir.service.AttuatoreService;
import edu.uniupo.pissir.service.IrrigazionePianificatoreService;
import edu.uniupo.pissir.service.SensoreService;
import edu.uniupo.pissir.service.SerraService;
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
public class SerraServiceImpl implements SerraService {

    private final SerraRepository serraRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );
    private final Logger logger = LoggerFactory.getLogger( SerraServiceImpl.class );
    private final SensoreService sensoreService;
    private final AttuatoreService attuatoreService;
    private final IrrigazionePianificatoreService irrigazionePianificatoreService;

    public SerraServiceImpl ( SerraRepository serraRepository, SensoreService sensoreService, AttuatoreService attuatoreService,
                              IrrigazionePianificatoreService irrigazionePianificatoreService ) {
        this.serraRepository = serraRepository;
        this.sensoreService = sensoreService;
        this.attuatoreService = attuatoreService;
        this.irrigazionePianificatoreService = irrigazionePianificatoreService;
    }



    @Override
    public SerraModel createSerra ( HttpSession session, SerraModel serraModel ) throws Exception {
        logger.info( "The create serra method has been called ..." );
        DefaultModel.checkModelType( serraModel, this.getClass().getName(), "createSerra" );
        SerraEntity serraEntity = serraRepository.save( mapper.modelToEntityOfSerra( serraModel ) );
        return mapper.entityToModelOfSerra( serraEntity );
    }

    @Override
    public SerraModel updateSerra ( HttpSession session, SerraModel serraModel ) throws Exception {
        logger.info( "The update serra method has been called ..." );
        DefaultModel.checkModelType( serraModel, this.getClass().getName(), "updateSerra" );
        SerraEntity oldSerra = OptionalUnpacker.unpackerOrThrows( serraRepository.findById( serraModel.getIdSerra() ),
                                                                  "Not found data of this serra in server" );
        mapper.updateSerraEntity( serraModel, oldSerra );
        return mapper.entityToModelOfSerra( oldSerra );
    }

    @Override
    public DeleteResponseModel deleteSerra ( HttpSession session, UUID idSerra ) throws Exception {
        logger.info( "The delete serra method has been called ..." );
        SerraEntity serraEntity = OptionalUnpacker.unpackerOrThrows( serraRepository.findById( idSerra ),
                                                                     "Not found data of this serra in server" );

        List<SensoreModel> sensores = sensoreService.findSensoreByIdSerra( session, idSerra );
        if(sensores.size() != 0){
            sensores.forEach( sensore -> {
                try {
                    sensoreService.deleteSensoreByIdSensore( session, sensore.getIdSensore() );
                } catch( Exception e ) {
                    throw new RuntimeException( e );
                }
            } );
        }

        List<AttuatoreModel> attuatores = attuatoreService.findAttuatoreByIdSerra( session, idSerra );
        if(attuatores.size() != 0){
            attuatores.forEach( attuatore -> attuatoreService.deleteAttuatoreById( session, attuatore.getIdAttuatore() ) );
        }

        List<IrrigazionePianificatoreModel> pianificatores = irrigazionePianificatoreService.findIrrigazionePianificatoreByIdserra( session, idSerra );
        if(pianificatores.size() != 0){
            pianificatores.forEach( pianificatore -> {
                try {
                    irrigazionePianificatoreService.deleteIrrigazionePianificatoreById(session, pianificatore.getIdIrrigazionePianificatore());
                } catch( Exception e ) {
                    throw new RuntimeException( e );
                }
            } );
        }

        serraRepository.deleteById( serraEntity.getIdSerra() );
        return new DeleteResponseModel( "Serra is deleted", true );
    }

    @Override
    public List<SerraModel> findSerraByIdAziendaAgricola ( HttpSession session, UUID idAziendaAgricola ) throws Exception {
        logger.info( "The find serra with id of azienda method has been called ..." );
        List<SerraEntity> serre = OptionalUnpacker.unpackerOrThrows( serraRepository.findByAziendaAgricolaEntityIdAziendaAgricola( idAziendaAgricola ),
                                                                     "Have not found data of serra with the given id of azienda" );
        return mapper.entityToModelListOfSerra( serre );
    }
}
