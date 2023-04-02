package edu.uniupo.pissir.serviceTests;

import edu.uniupo.pissir.entity.RuoloEntity;
import edu.uniupo.pissir.entity.UtenteEntity;
import edu.uniupo.pissir.mapper.ModelsToEntities;
import edu.uniupo.pissir.model.RuoloModel;
import edu.uniupo.pissir.model.UtenteModel;
import edu.uniupo.pissir.repository.UtenteRepository;
import edu.uniupo.pissir.service.UtenteService;
import edu.uniupo.pissir.service.implement.UtenteServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@SpringBootTest( useMainMethod = SpringBootTest.UseMainMethod.NEVER, webEnvironment = SpringBootTest.WebEnvironment.NONE )
@ExtendWith( { MockitoExtension.class } )
@ActiveProfiles( "test" )
public class UtenteEntityServiceTest {

    @Mock
    private UtenteRepository utenteRepository;
    @Mock
    private HttpSession session;
    private final ModelsToEntities mapper = spy( Mappers.getMapper( ModelsToEntities.class ) );
    private UtenteService utenteService;

    @BeforeEach
    void setUp () {
        utenteService = new UtenteServiceImpl( utenteRepository );
    }

    @Test
    public void shouldCreateUtente () throws Throwable {
        //Given
        ArgumentCaptor<UtenteModel> mapperParamDTOUtenteCaptor = ArgumentCaptor.forClass( UtenteModel.class );
        ArgumentCaptor<UtenteEntity> mapperParamUtenteCaptor = ArgumentCaptor.forClass( UtenteEntity.class );
        ArgumentCaptor<UtenteEntity> repositorySaveParamCaptor = ArgumentCaptor.forClass( UtenteEntity.class );

        UtenteModel utenteModel = new UtenteModel( "Jeremie", "Prince", "jeremie@email.com", "1234", RuoloModel.AGRICOLTORE );
        UtenteEntity utenteEntity = new UtenteEntity( UUID.randomUUID(), "Jeremie", "Prince", "jeremie@email.com", "1234", RuoloEntity.AGRICOLTORE );

        //When
        doReturn( utenteEntity ).when( utenteRepository ).save( any( UtenteEntity.class ) );

        when( mapper.modelToEntityOfUtente( utenteModel ) ).thenCallRealMethod();
        when( mapper.entityToModelOfUtente( utenteEntity ) ).thenCallRealMethod();

        UtenteModel candidateForEvaluation = utenteService.createUtente( session, utenteModel );

        //Then
        verify( utenteRepository ).save( repositorySaveParamCaptor.capture() );
        verify( mapper ).modelToEntityOfUtente( mapperParamDTOUtenteCaptor.capture() );
        verify( mapper ).entityToModelOfUtente( mapperParamUtenteCaptor.capture() );

        assertThat( candidateForEvaluation ).hasNoNullFieldsOrProperties();
        assertThat( candidateForEvaluation ).isExactlyInstanceOf( UtenteModel.class );
        assertThat( candidateForEvaluation.getIdUtente() ).isEqualTo( utenteEntity.getIdUtente() );
        assertThat( candidateForEvaluation.getEmail() ).isEqualTo( utenteEntity.getEmail() );


    }
}
