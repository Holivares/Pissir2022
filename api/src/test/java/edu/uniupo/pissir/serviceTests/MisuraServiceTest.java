package edu.uniupo.pissir.serviceTests;

import edu.uniupo.pissir.entity.*;
import edu.uniupo.pissir.model.MisuraModel;
import edu.uniupo.pissir.model.SensoreModel;
import edu.uniupo.pissir.model.TipoSensoreModel;
import edu.uniupo.pissir.repository.MisuraRepository;
import edu.uniupo.pissir.service.MisuraService;
import edu.uniupo.pissir.service.implement.MisuraServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
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
public class MisuraServiceTest {
    @Mock
    private MisuraRepository misuraRepository;
    private MisuraService misuraService;
    private MisuraEntity misuraEntity;
    private MisuraModel misuraModel;
    @InjectMocks
    private MockHttpSession mockHttpSession;

    @BeforeEach
    void setUp() {
        misuraService = new MisuraServiceImpl(misuraRepository);

        UtenteEntity utenteEntity = new UtenteEntity(UUID.randomUUID(), "Holivares", "Ngali", "evrardngali12@gmil.com", "1424", RuoloEntity.AGRICOLTORE);

        AziendaAgricolaEntity aziendaAgricolaEntity = new AziendaAgricolaEntity(UUID.randomUUID(), List.of(utenteEntity), "Azienda 1", "this is a first azienda for my test implementation");

        SerraEntity serraEntity = new SerraEntity(UUID.randomUUID(), aziendaAgricolaEntity, "this is a first serra for my test implementation...");

        SensoreEntity sensoreEntity = new SensoreEntity(UUID.randomUUID(), serraEntity, TipoSensoreEntity.LUCE);

        SensoreModel sensoreModel = new SensoreModel(serraEntity.getIdSerra(), TipoSensoreModel.LUCE);

        misuraEntity = new MisuraEntity(UUID.randomUUID(), sensoreEntity, new BigDecimal("20"));

        misuraModel = new MisuraModel(sensoreEntity.getIdSensore(), new BigDecimal("20"));
    }

    @Test
    public void shouldCreateMisura() throws Throwable {

        //Given
        ArgumentCaptor<MisuraEntity> repositorySaveParamMisuraCaptor = ArgumentCaptor.forClass(MisuraEntity.class);

        //When
        doReturn(misuraEntity).when(misuraRepository).save(any(MisuraEntity.class));
        MisuraModel misura = misuraService.createMisura(mockHttpSession,misuraModel);

        //Then
        verify(misuraRepository).save(repositorySaveParamMisuraCaptor.capture());
    }

    @Test
    public void shouldFindMisuraById() throws Throwable {
        //Given
        ArgumentCaptor<UUID> repositoryFindParamMisuraCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(misuraEntity)).when(misuraRepository).findById(any(UUID.class));
        MisuraModel misura = misuraService.findMisuraById(mockHttpSession,UUID.randomUUID());

        //Then

        verify(misuraRepository).findById(repositoryFindParamMisuraCaptor.capture());

    }
    @Test
    public void shouldFindMisuraBySensoreId() throws Throwable{

        //Given
        ArgumentCaptor<UUID> repositoryFindBySensoreIdParamMisuraCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(List.of(misuraEntity))).when(misuraRepository).findBySensoreEntityIdSensore(any(UUID.class));
        List<MisuraModel> misuraModelList = misuraService.findMisuraBySensoreId(mockHttpSession,UUID.randomUUID());

        //Then
        verify(misuraRepository).findBySensoreEntityIdSensore(repositoryFindBySensoreIdParamMisuraCaptor.capture());

    }

}
