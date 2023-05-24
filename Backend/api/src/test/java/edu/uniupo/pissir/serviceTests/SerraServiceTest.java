package edu.uniupo.pissir.serviceTests;


import edu.uniupo.pissir.entity.AziendaAgricolaEntity;
import edu.uniupo.pissir.entity.RuoloEntity;
import edu.uniupo.pissir.entity.SerraEntity;
import edu.uniupo.pissir.entity.UtenteEntity;
import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.SerraModel;
import edu.uniupo.pissir.repository.SerraRepository;
import edu.uniupo.pissir.service.AttuatoreService;
import edu.uniupo.pissir.service.IrrigazionePianificatoreService;
import edu.uniupo.pissir.service.SensoreService;
import edu.uniupo.pissir.service.SerraService;
import edu.uniupo.pissir.service.implement.SerraServiceImpl;
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
public class SerraServiceTest {
    @Mock
    private SerraRepository serraRepository;

    private SerraService serraService;
    @Mock
    private SensoreService sensoreService;
    @Mock
    private AttuatoreService attuatoreService;
    @Mock
    private IrrigazionePianificatoreService pianificatoreService;
    private SerraEntity serraEntity;
    private SerraModel serraModel;
    private AziendaAgricolaEntity aziendaAgricolaEntity;
    @InjectMocks
    private MockHttpSession mockHttpSession;

    @BeforeEach
    void setUp(){

        serraService = new SerraServiceImpl(serraRepository, sensoreService, attuatoreService, pianificatoreService);

        UtenteEntity utenteEntity = new UtenteEntity(UUID.randomUUID(), "Holivares", "Ngali", "evrardngali12@gmil.com", "1424", RuoloEntity.AGRICOLTORE);

        aziendaAgricolaEntity = new AziendaAgricolaEntity(UUID.randomUUID(), List.of(utenteEntity), "Azienda 1", "this is a first azienda for my test implementation");

        serraEntity = new SerraEntity(UUID.randomUUID(), aziendaAgricolaEntity, "this is a first serra for my test implementation...");

        serraModel = new SerraModel(aziendaAgricolaEntity.getIdAziendaAgricola(),"this is a first serra for my test implementation...");

    }

    @Test
    public void shouldCreateSerra() throws Throwable{
        //Given
        ArgumentCaptor<SerraModel> mapperParamDTOSerraCaptor = ArgumentCaptor.forClass(SerraModel.class);
        ArgumentCaptor<SerraEntity> repositotySaveParamSerraCaptor = ArgumentCaptor.forClass(SerraEntity.class);

        //When
        doReturn(serraEntity).when(serraRepository).save(any(SerraEntity.class));
        SerraModel serviceSerra = serraService.createSerra(mockHttpSession,serraModel);

        //Then
        verify(serraRepository).save(repositotySaveParamSerraCaptor.capture());

    }
    @Test
    public void shouldUpdateSerra() throws Throwable{

        //Given
        ArgumentCaptor<UUID> repositotyUpdateParamSerraCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(serraEntity)).when(serraRepository).findById(any(UUID.class));
        SerraModel updateSerra = serraService.updateSerra(mockHttpSession,new SerraModel(UUID.randomUUID(),aziendaAgricolaEntity.getIdAziendaAgricola(),"this is a update of serra for my test implementation..."));

        //Then
        verify(serraRepository).findById(repositotyUpdateParamSerraCaptor.capture());


    }
    @Test
    public void shouldDeleteSerra() throws Throwable{
        //Given
        ArgumentCaptor<UUID> repositotyDeleteParamSerraCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(serraEntity)).when(serraRepository).findById(any(UUID.class));
        DeleteResponseModel deleteResponseModel = serraService.deleteSerra(mockHttpSession,UUID.randomUUID());

        //Then
        verify(serraRepository).findById(repositotyDeleteParamSerraCaptor.capture());

    }
    @Test
    public void shouldFindSerraByIdAziendaAgricola() throws Throwable{
        //Given
        ArgumentCaptor<UUID> repositotyFindParamSerraCaptor = ArgumentCaptor.forClass(UUID.class);

        //When
        doReturn(Optional.of(List.of(serraEntity))).when(serraRepository).findByAziendaAgricolaEntityIdAziendaAgricola(any(UUID.class));
        serraService.findSerraByIdAziendaAgricola(mockHttpSession,UUID.randomUUID());

        //Then
        verify(serraRepository).findByAziendaAgricolaEntityIdAziendaAgricola(repositotyFindParamSerraCaptor.capture());

    }
}

