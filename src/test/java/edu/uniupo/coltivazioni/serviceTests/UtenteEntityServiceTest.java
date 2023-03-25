package edu.uniupo.coltivazioni.serviceTests;

import edu.uniupo.coltivazioni.entity.RuoloEntity;
import edu.uniupo.coltivazioni.entity.UtenteEntity;
import edu.uniupo.coltivazioni.mapper.ModelsToEntities;
import edu.uniupo.coltivazioni.model.RuoloModel;
import edu.uniupo.coltivazioni.model.UtenteModel;
import edu.uniupo.coltivazioni.repository.UtenteRepository;
import edu.uniupo.coltivazioni.service.UtenteService;
import edu.uniupo.coltivazioni.service.implement.UtenteServiceImpl;
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
    private final ModelsToEntities modelsToEntities = spy( Mappers.getMapper( ModelsToEntities.class ) );
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

        when( modelsToEntities.modelToEntityOfUtente( utenteModel ) ).thenCallRealMethod();
        when( modelsToEntities.entityToModelOfUtente( utenteEntity ) ).thenCallRealMethod();

        UtenteModel candidateForEvaluation = utenteService.createUtente( utenteModel );

        //Then
        verify( utenteRepository ).save( repositorySaveParamCaptor.capture() );
        verify( modelsToEntities ).modelToEntityOfUtente( mapperParamDTOUtenteCaptor.capture() );
        verify( modelsToEntities ).entityToModelOfUtente( mapperParamUtenteCaptor.capture() );

        assertThat( candidateForEvaluation ).hasNoNullFieldsOrProperties();
        assertThat( candidateForEvaluation ).isExactlyInstanceOf( UtenteModel.class );
        assertThat( candidateForEvaluation.getIdUtente() ).isEqualTo( utenteEntity.getIdUtente() );
        assertThat( candidateForEvaluation.getEmail() ).isEqualTo( utenteEntity.getEmail() );


    }
}
