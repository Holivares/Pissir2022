package edu.uniupo.coltivazioni.service.implement;

import edu.uniupo.coltivazioni.entity.AziendaAgricolaEntity;
import edu.uniupo.coltivazioni.mapper.ModelsToEntities;
import edu.uniupo.coltivazioni.model.AziendaAgricolaModel;
import edu.uniupo.coltivazioni.model.DeleteResponseModel;
import edu.uniupo.coltivazioni.repository.AziendaAgricolaRepository;
import edu.uniupo.coltivazioni.service.AziendaAgricolaService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AziendaAgricolaServiceImpl implements AziendaAgricolaService {
    private final AziendaAgricolaRepository aziendaAgricolaRepository;
    private final ModelsToEntities mapper = Mappers.getMapper( ModelsToEntities.class );

    @Autowired
    public AziendaAgricolaServiceImpl ( AziendaAgricolaRepository aziendaAgricolaRepository ) {
        this.aziendaAgricolaRepository = aziendaAgricolaRepository;
    }

    @Override
    public AziendaAgricolaModel createAziendaAgricola ( AziendaAgricolaModel aziendaAgricolaModel ) {
        AziendaAgricolaEntity azienda = aziendaAgricolaRepository.save( mapper.modelToEntityOfAziendaAgricola( aziendaAgricolaModel ) );
        return mapper.entityToModelOfAziendaAgricola( azienda );
    }

    @Override
    public AziendaAgricolaModel updateAziendaAgricola ( AziendaAgricolaModel aziendaAgricolaModel ) {
        AziendaAgricolaEntity azienda = aziendaAgricolaRepository.save( mapper.modelToEntityOfAziendaAgricola( aziendaAgricolaModel ) );
        return mapper.entityToModelOfAziendaAgricola( azienda );
    }

    @Override
    public DeleteResponseModel deleteAziendaAgricola ( UUID idAziendaAgricola ) {
        aziendaAgricolaRepository.deleteById( idAziendaAgricola );
        return new DeleteResponseModel( "Azienda Agricola is deleted", true );
    }

    @Override
    public AziendaAgricolaModel findAziendaAgricolaByIdUser ( UUID idUtente ) {
        Optional<AziendaAgricolaEntity> azienda = aziendaAgricolaRepository.findByUtenteEntityIdUtente( idUtente );
        return mapper.entityToModelOfAziendaAgricola( azienda.orElse( new AziendaAgricolaEntity() ) );
    }

    @Override
    public AziendaAgricolaModel findAziendaAgricolaById ( UUID idAziendaAgricola ) {
        Optional<AziendaAgricolaEntity> azienda = aziendaAgricolaRepository.findById( idAziendaAgricola );
        return mapper.entityToModelOfAziendaAgricola( azienda.orElse( new AziendaAgricolaEntity() ) );
    }

    @Override
    public AziendaAgricolaModel findAziendaAgricolaByName ( String nome ) {
        Optional<AziendaAgricolaEntity> azienda = aziendaAgricolaRepository.findByNome( nome );
        return mapper.entityToModelOfAziendaAgricola( azienda.orElse( new AziendaAgricolaEntity() ) );
    }
}
