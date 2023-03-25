package edu.uniupo.coltivazioni.service.implement;

import edu.uniupo.coltivazioni.entity.IrrigazionePianificatoreEntity;
import edu.uniupo.coltivazioni.mapper.ModelsToEntities;
import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.model.IrrigazionePianificatoreModel;
import edu.uniupo.coltivazioni.repository.IrrigazionePianificatoreRepository;
import edu.uniupo.coltivazioni.service.IrrigazionePianificatoreService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class IrrigazionePianificatoreServiceImpl implements IrrigazionePianificatoreService {

    private final IrrigazionePianificatoreRepository irrigazionePianificatoreRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );

    @Autowired
    public IrrigazionePianificatoreServiceImpl ( IrrigazionePianificatoreRepository irrigazionePianificatoreRepository ) {
        this.irrigazionePianificatoreRepository = irrigazionePianificatoreRepository;
    }

    @Override
    public IrrigazionePianificatoreModel createIrrigazionePianificatore ( IrrigazionePianificatoreModel irrigazionePianificatoreModel ) {
        IrrigazionePianificatoreEntity pianificatore =
                irrigazionePianificatoreRepository.save( mapper.modelToEntityOfIrrigazionePianificatore( irrigazionePianificatoreModel ) );
        return mapper.entityToModelOfIrrigazionePianificatore( pianificatore );
    }

    @Override
    public IrrigazionePianificatoreModel updateIrrigazionePianificatore ( IrrigazionePianificatoreModel irrigazionePianificatoreModel ) {
        IrrigazionePianificatoreEntity pianificatore =
                irrigazionePianificatoreRepository.save( mapper.modelToEntityOfIrrigazionePianificatore( irrigazionePianificatoreModel ) );
        return mapper.entityToModelOfIrrigazionePianificatore( pianificatore );
    }

    @Override
    public DeleteResponseModel deleteIrrigazionePianificatoreById ( UUID idIrrigazionePianificatore ) {
        irrigazionePianificatoreRepository.deleteById( idIrrigazionePianificatore );
        return new DeleteResponseModel( "Piano irrigazione is deleted", true );
    }

    @Override
    public IrrigazionePianificatoreModel findIrrigazionePianificatoreByIdAziendaAgricola ( UUID idAziendaAgricola ) {
        Optional<IrrigazionePianificatoreEntity> pianificatore =
                irrigazionePianificatoreRepository.findByAziendaAgricolaEntityIdAziendaAgricola( idAziendaAgricola );
        return mapper.entityToModelOfIrrigazionePianificatore( pianificatore.orElse( new IrrigazionePianificatoreEntity() ) );
    }

    @Override
    public IrrigazionePianificatoreModel findIrrigazionePianificatoreByIdserra ( UUID idSerra ) {
        Optional<IrrigazionePianificatoreEntity> pianificatore = irrigazionePianificatoreRepository.findBySerraEntityIdSerra( idSerra );
        return mapper.entityToModelOfIrrigazionePianificatore( pianificatore.orElse( new IrrigazionePianificatoreEntity() ) );
    }
}
