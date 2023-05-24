package edu.uniupo.pissir.serviceTests;


import edu.uniupo.pissir.entity.*;
import edu.uniupo.pissir.model.SensoreModel;
import edu.uniupo.pissir.model.TipoSensoreModel;
import edu.uniupo.pissir.repository.SensoreRepository;
import edu.uniupo.pissir.service.MisuraService;
import edu.uniupo.pissir.service.SensoreService;
import edu.uniupo.pissir.service.implement.SensoreServiceImpl;
import org.junit.jupiter.api.BeforeEach;
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
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * @author
 * @author
 */
@ExtendWith({MockitoExtension.class})
@ActiveProfiles("test")
public class SensoreServiceTest {
    @Mock
    private SensoreRepository sensoreRepository;

    private SensoreService sensoreService;
    @Mock
    private MisuraService misuraService;
    private SensoreEntity sensoreEntity;
    private SensoreModel sensoreModel;
    @InjectMocks
    private MockHttpSession mockHttpSession;
    @BeforeEach
    void setUp(){

        sensoreService = new SensoreServiceImpl(sensoreRepository, misuraService);

        UtenteEntity utenteEntity = new UtenteEntity(UUID.randomUUID(), "Holivares", "Ngali", "evrardngali12@gmil.com", "1424", RuoloEntity.AGRICOLTORE);

        AziendaAgricolaEntity aziendaAgricolaEntity = new AziendaAgricolaEntity(UUID.randomUUID(), List.of(utenteEntity), "Azienda 1", "this is a first azienda for my test implementation");

        SerraEntity serraEntity = new SerraEntity(UUID.randomUUID(), aziendaAgricolaEntity, "this is a first serra for my test implementation...");

        sensoreEntity = new SensoreEntity(UUID.randomUUID(), serraEntity, TipoSensoreEntity.LUCE);

        sensoreModel = new SensoreModel(serraEntity.getIdSerra(), TipoSensoreModel.LUCE);

    }
    @Test
    public void shouldCreateSensore() throws Throwable{

        //Given
        ArgumentCaptor<SensoreEntity> repositorySaveParamSensoreCaptor = ArgumentCaptor.forClass(SensoreEntity.class);

        //When
        doReturn(sensoreEntity).when(sensoreRepository).save(any(SensoreEntity.class));
        SensoreModel sensore = sensoreService.createSensore(mockHttpSession,sensoreModel);

        //Then
        verify(sensoreRepository).save(repositorySaveParamSensoreCaptor.capture());

    }
    @Test
    public void shouldFindSensoreByIdSerra() throws Throwable{

        //Given
        ArgumentCaptor<UUID> repositoryFindParamSensoreCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(List.of(sensoreEntity))).when(sensoreRepository).findBySerraEntityIdSerra(any(UUID.class));
        List<SensoreModel> sensore = sensoreService.findSensoreByIdSerra(mockHttpSession,UUID.randomUUID());

        //Then
        verify(sensoreRepository).findBySerraEntityIdSerra(repositoryFindParamSensoreCaptor.capture());

    }

}
