package edu.uniupo.pissir.serviceTests;


import edu.uniupo.pissir.entity.RuoloEntity;
import edu.uniupo.pissir.entity.UtenteEntity;
import edu.uniupo.pissir.mapper.ModelsToEntities;
import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.RuoloModel;
import edu.uniupo.pissir.model.UtenteAutenticazioneModel;
import edu.uniupo.pissir.model.UtenteModel;
import edu.uniupo.pissir.repository.UtenteRepository;
import edu.uniupo.pissir.service.IotConnectionService;
import edu.uniupo.pissir.service.UtenteService;
import edu.uniupo.pissir.service.implement.UtenteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@SpringBootTest( useMainMethod = SpringBootTest.UseMainMethod.NEVER, webEnvironment = SpringBootTest.WebEnvironment.NONE )
@ExtendWith({MockitoExtension.class})
@ActiveProfiles("test")
public class UtenteEntityServiceTest {

    @Mock
    private UtenteRepository utenteRepository;
    private final ModelsToEntities modelsToEntities = spy(Mappers.getMapper(ModelsToEntities.class));
    private UtenteService utenteService;
    @Mock
    private IotConnectionService iotConnectionService;
    private UtenteModel utenteModel;
    private UtenteEntity utenteEntity;
    private UtenteAutenticazioneModel utenteAutenticazioneModel;
    @InjectMocks
    private MockHttpSession mockHttpSession;

    @BeforeEach
    void setUp() {
        utenteService = new UtenteServiceImpl(utenteRepository, iotConnectionService);
        utenteModel = new UtenteModel("Jeremie", "Prince", "jeremie@email.com", "1234", RuoloModel.AGRICOLTORE);
        utenteEntity = new UtenteEntity(UUID.randomUUID(), "Jeremie", "Prince", "jeremie@email.com", "1234", RuoloEntity.AGRICOLTORE);
        utenteAutenticazioneModel = new UtenteAutenticazioneModel("evrardngali12@gmail.com", "1994!");

    }

    @Test
    public void shouldCreateUtente() throws Throwable {
        //Given
        ArgumentCaptor<UtenteModel> mapperParamDTOUtenteCaptor = ArgumentCaptor.forClass(UtenteModel.class);
        ArgumentCaptor<UtenteEntity> mapperParamUtenteCaptor = ArgumentCaptor.forClass(UtenteEntity.class);
        ArgumentCaptor<UtenteEntity> repositorySaveParamCaptor = ArgumentCaptor.forClass(UtenteEntity.class);


        //When
        doReturn(utenteEntity).when(utenteRepository).save(any(UtenteEntity.class));

        when(modelsToEntities.modelToEntityOfUtente(utenteModel)).thenCallRealMethod();
        when(modelsToEntities.entityToModelOfUtente(utenteEntity)).thenCallRealMethod();

        UtenteModel candidateForEvaluation = utenteService.createUtente(mockHttpSession,utenteModel);

        //Then
        verify(utenteRepository).save(repositorySaveParamCaptor.capture());
        verify(modelsToEntities).modelToEntityOfUtente(mapperParamDTOUtenteCaptor.capture());
        verify(modelsToEntities).entityToModelOfUtente(mapperParamUtenteCaptor.capture());

        assertThat(candidateForEvaluation).hasNoNullFieldsOrProperties();
        assertThat(candidateForEvaluation).isExactlyInstanceOf(UtenteModel.class);
        assertThat(candidateForEvaluation.getIdUtente()).isEqualTo(utenteEntity.getIdUtente());
        assertThat(candidateForEvaluation.getEmail()).isEqualTo(utenteEntity.getEmail());


    }

    @Test
    public void shouldUpdateUtente() throws Throwable {

        //Given
        ArgumentCaptor<UUID> repositoryUpdateParamCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(utenteEntity)).when(utenteRepository).findById(any(UUID.class));
        UtenteModel updateUtente = utenteService.updateUtente(mockHttpSession,utenteModel);

        //Then
        verify(utenteRepository).findById(repositoryUpdateParamCaptor.capture());


    }

    @Test
    public void shouldDeleteUtenteById() throws Throwable {
        //Given
        ArgumentCaptor<UUID> repositorydeleteParamCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(utenteEntity)).when(utenteRepository).findById(any(UUID.class));
        doNothing().when(utenteRepository).deleteById(any(UUID.class));
        DeleteResponseModel deleteResponseModel = utenteService.deleteUtenteById(mockHttpSession,utenteEntity.getIdUtente());

        //Then
        verify(utenteRepository).deleteById(repositorydeleteParamCaptor.capture());

    }

    @Test
    public void shouldFindUtenteByEmailAndPassword() throws Throwable {

        //Given
        ArgumentCaptor<String> repositoryEmailParamCaptor = ArgumentCaptor.forClass(String.class);

        //When
        doReturn(Optional.of(utenteEntity)).when(utenteRepository).findByEmail(any(String.class));
        UtenteModel utente = utenteService.findUtenteByEmailAndPassword(mockHttpSession,utenteAutenticazioneModel);

        //Then
        verify(utenteRepository).findByEmail(repositoryEmailParamCaptor.capture());



    }
}
