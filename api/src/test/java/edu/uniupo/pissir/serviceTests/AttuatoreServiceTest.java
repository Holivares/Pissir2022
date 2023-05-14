package edu.uniupo.pissir.serviceTests;


import edu.uniupo.pissir.entity.*;
import edu.uniupo.pissir.model.*;
import edu.uniupo.pissir.repository.AttuatoreRepository;
import edu.uniupo.pissir.service.AttuatoreService;
import edu.uniupo.pissir.service.implement.AttuatoreServiceImpl;
import jakarta.servlet.http.HttpSession;
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
public class AttuatoreServiceTest {
    @Mock
    private AttuatoreRepository attuatoreRepository;
    private AttuatoreService attuatoreService;
    private AttuatoreEntity attuatoreEntity;
    private AttuatoreModel attuatoreModel;
    @InjectMocks
    private MockHttpSession mockHttpSession;

    @BeforeEach
    void setUp() {

        attuatoreService = new AttuatoreServiceImpl(attuatoreRepository);

        UtenteEntity utenteEntity = new UtenteEntity(UUID.randomUUID(), "Holivares", "Ngali", "evrardngali12@gmil.com", "1424", RuoloEntity.AGRICOLTORE);

        AziendaAgricolaEntity aziendaAgricolaEntity = new AziendaAgricolaEntity(UUID.randomUUID(), List.of(utenteEntity), "Azienda 1", "this is a first azienda for my test implementation");

        SerraEntity serraEntity = new SerraEntity(UUID.randomUUID(), aziendaAgricolaEntity, "this is a first serra for my test implementation...");

        attuatoreEntity = new AttuatoreEntity(UUID.randomUUID(), serraEntity, new StatoAttuatoreEntity(AttuatoreModeEntity.MANUALE, AttuatoreStatoEntity.ATTIVO), TipoAttuatoreEntity.ILLUMINAZIONE);

        attuatoreModel = new AttuatoreModel(serraEntity.getIdSerra(), new StatoAttuatoreModel(AttuatoreModeModel.MANUALE, AttuatoreStatoModel.ATTIVO), TipoAttuatoreModel.ILLUMINAZIONE);


    }

    @Test
    public void shouldCreateAttuatore() throws Throwable {
        //Given
        ArgumentCaptor<AttuatoreModel> mapperParamDTOSerraCaptor = ArgumentCaptor.forClass(AttuatoreModel.class);
        ArgumentCaptor<AttuatoreEntity> repositorySaveParamAttuatoreCaptor = ArgumentCaptor.forClass(AttuatoreEntity.class);

        //When
        doReturn(attuatoreEntity).when(attuatoreRepository).save(any(AttuatoreEntity.class));
        AttuatoreModel attuatore = attuatoreService.createAttuatore(mockHttpSession, attuatoreModel);

        //Then
        verify(attuatoreRepository).save(repositorySaveParamAttuatoreCaptor.capture());

    }

    @Test
    public void shouldFindAttuatoreByIdSerra() throws Throwable {
        //Given
        ArgumentCaptor<UUID> repositoryFindParamAttuatoreCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(List.of(attuatoreEntity))).when(attuatoreRepository).findBySerraEntityIdSerra(any(UUID.class));
        List<AttuatoreModel> attuatore = attuatoreService.findAttuatoreByIdSerra(mockHttpSession,UUID.randomUUID());

        //Then
        verify(attuatoreRepository).findBySerraEntityIdSerra(repositoryFindParamAttuatoreCaptor.capture());

    }

    @Test
    public void shouldEnableAttuatore() throws Throwable {

        //Given
        ArgumentCaptor<UUID> repositoryEnableParamAttuatoreCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(attuatoreEntity)).when(attuatoreRepository).findById(any(UUID.class));
        AttuatoreModel attuatore = attuatoreService.enableAttuatore(mockHttpSession,UUID.randomUUID());

        //Then
        verify(attuatoreRepository).findById(repositoryEnableParamAttuatoreCaptor.capture());


    }

    @Test
    public void shouldDisableAttuatore() throws Throwable{

        //Given
        ArgumentCaptor<UUID> repositoryDisableParamAttuatoreCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(attuatoreEntity)).when(attuatoreRepository).findById(any(UUID.class));
        AttuatoreModel attuatore = attuatoreService.disableAttuatore(mockHttpSession,UUID.randomUUID());

        //Then
        verify(attuatoreRepository).findById(repositoryDisableParamAttuatoreCaptor.capture());


    }




}
