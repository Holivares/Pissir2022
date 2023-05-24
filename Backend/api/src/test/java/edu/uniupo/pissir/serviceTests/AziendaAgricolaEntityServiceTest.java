package edu.uniupo.pissir.serviceTests;

import edu.uniupo.pissir.entity.AziendaAgricolaEntity;
import edu.uniupo.pissir.entity.RuoloEntity;
import edu.uniupo.pissir.entity.UtenteEntity;
import edu.uniupo.pissir.model.AziendaAgricolaModel;
import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.repository.AziendaAgricolaRepository;
import edu.uniupo.pissir.repository.UtenteRepository;
import edu.uniupo.pissir.service.AziendaAgricolaService;
import edu.uniupo.pissir.service.implement.AziendaAgricolaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author
 * @author
 */
@ExtendWith({MockitoExtension.class})
@ActiveProfiles("test")
public class AziendaAgricolaEntityServiceTest {
    @Mock
    private AziendaAgricolaRepository aziendaAgricolaRepository;
    @Mock
    private UtenteRepository utenteRepository;

    //private final ModelsToEntities modelsToEntities = spy(Mappers.getMapper(ModelsToEntities.class));
    private AziendaAgricolaService aziendaAgricolaService;
    private AziendaAgricolaModel aziendaAgricolaModel;
    private AziendaAgricolaEntity aziendaAgricolaEntity;
    private UtenteEntity utenteEntity;
    @InjectMocks
    private MockHttpSession mockHttpSession;



    @BeforeEach
    void setUp() {

        utenteEntity = new UtenteEntity(UUID.randomUUID(), "Holivares", "Ngali", "evrardngali12@gmil.com", "1424", RuoloEntity.AGRICOLTORE);

        aziendaAgricolaService = new AziendaAgricolaServiceImpl(aziendaAgricolaRepository,utenteRepository);

        aziendaAgricolaModel = new AziendaAgricolaModel(List.of(utenteEntity.getIdUtente()), "azienda 1", "Coltivazione in serra");
        //Faux retour DB
        aziendaAgricolaEntity = new AziendaAgricolaEntity(UUID.randomUUID(), List.of(utenteEntity), "Azienda 1", "this is a first azienda for my test implementation");



    }

    @Test
    public void shouldCreateAziendaAgricola() throws Throwable {
        //Given
        ArgumentCaptor<AziendaAgricolaModel> mapperParamDTOAziendaAgricolaCaptor = ArgumentCaptor.forClass(AziendaAgricolaModel.class);
        ArgumentCaptor<AziendaAgricolaEntity> mapperParamAziendaAgricolaCaptor = ArgumentCaptor.forClass(AziendaAgricolaEntity.class);
        ArgumentCaptor<AziendaAgricolaEntity> repositorySaveParamAziendaAgricolaCaptor = ArgumentCaptor.forClass(AziendaAgricolaEntity.class);
        ArgumentCaptor<UtenteEntity> repositoryFindByIdUtetenteCaptor = ArgumentCaptor.forClass( UtenteEntity.class );


        //When
        doReturn(aziendaAgricolaEntity).when(aziendaAgricolaRepository).save(any(AziendaAgricolaEntity.class));
        doReturn( Optional.of( utenteEntity )  ).when(utenteRepository).findById( any(UUID.class) );
        AziendaAgricolaModel aziendaAgricola = aziendaAgricolaService.createAziendaAgricola(mockHttpSession,aziendaAgricolaModel);

        //Then
        verify( utenteRepository ).findById( any(UUID.class) );
        verify(aziendaAgricolaRepository).save(repositorySaveParamAziendaAgricolaCaptor.capture());

    }

    @Test
    public void shouldUpdateAziendaAgricola() throws Throwable {
        //Given
        ArgumentCaptor<UUID> repositoryUpdateParamAziendaAgricolaCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(aziendaAgricolaEntity)).when(aziendaAgricolaRepository).findById(any(UUID.class));
        AziendaAgricolaModel agricolaModel = aziendaAgricolaService.updateAziendaAgricola(mockHttpSession,new AziendaAgricolaModel(UUID.randomUUID(), List.of(utenteEntity.getIdUtente()), "azienda 1", "Coltivazione in serra"));

        //Then
        verify(aziendaAgricolaRepository).findById(repositoryUpdateParamAziendaAgricolaCaptor.capture());
    }

    @Test
    public void shouldDeleteAziendaAgricola() throws Throwable {
        //Given
        ArgumentCaptor<UUID> repositoryDeleteParamAziendaAgricolaCaptor = ArgumentCaptor.forClass(UUID.class);
        doReturn(Optional.of(aziendaAgricolaEntity)).when(aziendaAgricolaRepository).findById(any(UUID.class));
        doNothing().when(aziendaAgricolaRepository).deleteById(any(UUID.class));
        //When

        DeleteResponseModel deleteResponseModel = aziendaAgricolaService.deleteAziendaAgricola(mockHttpSession,aziendaAgricolaEntity.getIdAziendaAgricola());

        //Then
        verify(aziendaAgricolaRepository).deleteById(repositoryDeleteParamAziendaAgricolaCaptor.capture());


    }

    @Test
    public void shouldFindAziendaAgricolaByIdUser() throws Throwable {

        //Given
        ArgumentCaptor<UUID> repositoryFindParamAziendaAgricolaCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(aziendaAgricolaEntity)).when(aziendaAgricolaRepository).findByUtenteEntitiesIdUtente((any(UUID.class)));
        AziendaAgricolaModel aziendaAgricolaById = aziendaAgricolaService.findAziendaAgricolaByIdUser(mockHttpSession,UUID.randomUUID());

        //Then
        verify(aziendaAgricolaRepository).findByUtenteEntitiesIdUtente(repositoryFindParamAziendaAgricolaCaptor.capture());

    }

    @Test
    public void shouldFindAziendaAgricolaById() throws Throwable {

        //Given
        ArgumentCaptor<UUID> repositoryFindParamAziendaAgricolaCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(aziendaAgricolaEntity)).when(aziendaAgricolaRepository).findById(any(UUID.class));
        AziendaAgricolaModel aziendaAgricolaById = aziendaAgricolaService.findAziendaAgricolaById(mockHttpSession,UUID.randomUUID());

        //Then
        verify(aziendaAgricolaRepository).findById(repositoryFindParamAziendaAgricolaCaptor.capture());
    }
    @Test
    public void shouldFindAziendaAgricolaByName() throws Throwable{
        //Given
        ArgumentCaptor<String> repositoryFindParamAziendaAgricolaCaptor = ArgumentCaptor.forClass(String.class);

        //When
        doReturn(Optional.of(aziendaAgricolaEntity)).when(aziendaAgricolaRepository).findByNome(any(String.class));
        aziendaAgricolaService.findAziendaAgricolaByName(mockHttpSession,"Azienda 1");

        //Then
        verify(aziendaAgricolaRepository).findByNome(repositoryFindParamAziendaAgricolaCaptor.capture());

    }
}
