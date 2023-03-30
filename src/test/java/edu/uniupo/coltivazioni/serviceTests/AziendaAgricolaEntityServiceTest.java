package edu.uniupo.coltivazioni.serviceTests;

import edu.uniupo.coltivazioni.entity.AziendaAgricolaEntity;
import edu.uniupo.coltivazioni.mapper.ModelsToEntities;
import edu.uniupo.coltivazioni.model.AziendaAgricolaModel;
import edu.uniupo.coltivazioni.repository.AziendaAgricolaRepository;
import edu.uniupo.coltivazioni.service.AziendaAgricolaService;
import edu.uniupo.coltivazioni.service.implement.AziendaAgricolaServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.mockito.Mockito.spy;

/**
 * @author
 * @author
 */
@ExtendWith({MockitoExtension.class})
@ActiveProfiles("test")
public class AziendaAgricolaEntityServiceTest {
    @Mock
    private AziendaAgricolaRepository aziendaAgricolaRepository;

    private final ModelsToEntities modelsToEntities = spy(Mappers.getMapper(ModelsToEntities.class));
    private AziendaAgricolaService aziendaAgricolaService;

    void setUp(){
        aziendaAgricolaService = new AziendaAgricolaServiceImpl(aziendaAgricolaRepository);
    }

    public void shouldCreateAziendaAgricola() throws Throwable{
        //Given
        ArgumentCaptor<AziendaAgricolaModel> mapperParamDTOAziendaAgricolaCaptor = ArgumentCaptor.forClass(AziendaAgricolaModel.class);
        ArgumentCaptor<AziendaAgricolaEntity> mapperParamAziendaAgricolaCaptor = ArgumentCaptor.forClass(AziendaAgricolaEntity.class);
        ArgumentCaptor<AziendaAgricolaEntity> repositorySaveParamAziendaAgricolaCaptor = ArgumentCaptor.forClass(AziendaAgricolaEntity.class);

        AziendaAgricolaModel aziendaAgricolaModel = new AziendaAgricolaModel(UUID.randomUUID(),"azienda 1", "Coltivazione in serra");
    }
}
