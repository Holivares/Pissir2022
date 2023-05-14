package edu.uniupo.pissir.serviceTests;

import edu.uniupo.pissir.entity.*;
import edu.uniupo.pissir.model.ExecutionTimeModel;
import edu.uniupo.pissir.model.IrrigazionePianificatoreModel;
import edu.uniupo.pissir.repository.IrrigazionePianificatoreRepository;
import edu.uniupo.pissir.service.IrrigazionePianificatoreService;
import edu.uniupo.pissir.service.implement.IrrigazionePianificatoreServiceImpl;
import edu.uniupo.pissir.model.DeleteResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalTime;
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
public class IrrigazionePianificatoreServiceTest {
    @Mock
    private IrrigazionePianificatoreRepository pianificatoreRepository;
    private IrrigazionePianificatoreService pianificatoreService;
    private IrrigazionePianificatoreEntity irrigazionePianificatoreEntity;
    private IrrigazionePianificatoreModel irrigazionePianificatoreModel;
    private AziendaAgricolaEntity aziendaAgricolaEntity;
    private SerraEntity serraEntity;
    @InjectMocks
    private MockHttpSession mockHttpSession;


    @BeforeEach
    void setUp() {
        //Appel du costruttore
        pianificatoreService = new IrrigazionePianificatoreServiceImpl(pianificatoreRepository);

        irrigazionePianificatoreModel = new IrrigazionePianificatoreModel();

        UtenteEntity utenteEntity = new UtenteEntity(UUID.randomUUID(), "Holivares", "Ngali", "evrardngali12@gmil.com", "1424", RuoloEntity.AGRICOLTORE);

        aziendaAgricolaEntity = new AziendaAgricolaEntity(UUID.randomUUID(), List.of(utenteEntity), "Azienda 1", "this is a first azienda for my test implementation");

        serraEntity = new SerraEntity(UUID.randomUUID(), aziendaAgricolaEntity, "this is a first serra for my test implementation...");

        irrigazionePianificatoreModel = new IrrigazionePianificatoreModel(aziendaAgricolaEntity.getIdAziendaAgricola(), serraEntity.getIdSerra(), "Pianificatore1", LocalDate.of(2023, 1, 12), new ExecutionTimeModel(LocalTime.of(12, 30), LocalTime.of(16, 30)));
        //Faux DB
        irrigazionePianificatoreEntity = new IrrigazionePianificatoreEntity(UUID.randomUUID(), aziendaAgricolaEntity, serraEntity, "Pianificatore1", LocalDate.of(2023, 1, 12), new ExecutionTimeEntity(LocalTime.of(12, 30), LocalTime.of(16, 30)));


    }

    @Test
    public void shouldCreateIrrigazionePianificatore() throws Throwable {

        //Given
        ArgumentCaptor<IrrigazionePianificatoreModel> mapperParamDTOPianificatoreCaptor = ArgumentCaptor.forClass(IrrigazionePianificatoreModel.class);
        ArgumentCaptor<IrrigazionePianificatoreEntity> mapperParamPianificatoreCaptor = ArgumentCaptor.forClass(IrrigazionePianificatoreEntity.class);
        ArgumentCaptor<IrrigazionePianificatoreEntity> repositorySaveParamPianificatoreCaptor = ArgumentCaptor.forClass(IrrigazionePianificatoreEntity.class);

        //When
        doReturn(irrigazionePianificatoreEntity).when(pianificatoreRepository).save(any(IrrigazionePianificatoreEntity.class));
        IrrigazionePianificatoreModel pianificatoreModel = pianificatoreService.createIrrigazionePianificatore(mockHttpSession,irrigazionePianificatoreModel);

        //Then
        verify(pianificatoreRepository).save(repositorySaveParamPianificatoreCaptor.capture());

    }

    @Test
    public void shouldUpdateIrrigazionePianificatore() throws Throwable{

        //Given
        ArgumentCaptor<UUID> repositoryUpdateParamPianificatoreCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(irrigazionePianificatoreEntity)).when(pianificatoreRepository).findById(any(UUID.class));
        IrrigazionePianificatoreModel pianificatoreModel = pianificatoreService.updateIrrigazionePianificatore(mockHttpSession,new IrrigazionePianificatoreModel(UUID.randomUUID(),aziendaAgricolaEntity.getIdAziendaAgricola(), serraEntity.getIdSerra(), "Pianificatore1", LocalDate.of(2023, 1, 12), new ExecutionTimeModel(LocalTime.of(12, 30), LocalTime.of(16, 30))));


        //Then
        verify(pianificatoreRepository).findById(repositoryUpdateParamPianificatoreCaptor.capture());

    }
    @Test
    public void shouldDeleteIrrigazionePianificatoreById() throws Throwable{

        //Given
        ArgumentCaptor<UUID> repositoryDeleteParamPianificatoreCaptor = ArgumentCaptor.forClass(UUID.class);

        //When

        doReturn(Optional.of(irrigazionePianificatoreEntity)).when(pianificatoreRepository).findById(any(UUID.class));
        DeleteResponseModel deleteResponseModel = pianificatoreService.deleteIrrigazionePianificatoreById(mockHttpSession,irrigazionePianificatoreEntity.getIdIrrigazionePianificatore());

        //Then
        verify(pianificatoreRepository).deleteById(repositoryDeleteParamPianificatoreCaptor.capture());
    }

    @Test
    public void shouldFindIrrigazionePianificatoreByIdAziendaAgricola() throws Throwable{

        //Given
        ArgumentCaptor<UUID> repositoryFindParamPianificatoreCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(List.of(irrigazionePianificatoreEntity))).when(pianificatoreRepository).findByAziendaAgricolaEntityIdAziendaAgricola(any(UUID.class));
        pianificatoreService.findIrrigazionePianificatoreByIdAziendaAgricola(mockHttpSession,UUID.randomUUID());


        //Then
        verify(pianificatoreRepository).findByAziendaAgricolaEntityIdAziendaAgricola(repositoryFindParamPianificatoreCaptor.capture());
    }

    @Test
    public void shouldFindIrrigazionePianificatoreByIdserra() throws Throwable{

        //Given
        ArgumentCaptor<UUID> repositoryFindParamPianificatoreCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(List.of(irrigazionePianificatoreEntity))).when(pianificatoreRepository).findBySerraEntityIdSerra(any(UUID.class));
        List<IrrigazionePianificatoreModel> pianificatoreByIdserra = pianificatoreService.findIrrigazionePianificatoreByIdserra(mockHttpSession,UUID.randomUUID());

        //Then
        verify(pianificatoreRepository).findBySerraEntityIdSerra(repositoryFindParamPianificatoreCaptor.capture());
    }


}

