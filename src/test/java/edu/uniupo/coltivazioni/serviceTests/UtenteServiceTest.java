package edu.uniupo.coltivazioni.serviceTests;

import edu.uniupo.coltivazioni.dto.DTORuolo;
import edu.uniupo.coltivazioni.dto.DTOUtente;
import edu.uniupo.coltivazioni.entities.Ruolo;
import edu.uniupo.coltivazioni.entities.Utente;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.UtenteRepositori;
import edu.uniupo.coltivazioni.services.UtenteServices;
import edu.uniupo.coltivazioni.services.UtenteServicesImpl;
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
public class UtenteServiceTest {

    @Mock
    private UtenteRepositori utenteRepositori;
    private final ObjectMapper objectMapper = spy( Mappers.getMapper( ObjectMapper.class ) );
    private UtenteServices utenteServices;

    @BeforeEach
    void setUp () {
        utenteServices = new UtenteServicesImpl( utenteRepositori );
    }

    @Test
    public void shouldCreateUtente () {
        //Given
        ArgumentCaptor<DTOUtente> mapperParamDTOUtenteCaptor = ArgumentCaptor.forClass( DTOUtente.class );
        ArgumentCaptor<Utente> mapperParamUtenteCaptor = ArgumentCaptor.forClass( Utente.class );
        ArgumentCaptor<Utente> repositorySaveParamCaptor = ArgumentCaptor.forClass( Utente.class );

        DTOUtente dtoUtente = new DTOUtente( "Jeremie", "Prince", "jeremie@email.com", "1234", DTORuolo.AGRICOLTORE );
        Utente utente = new Utente( UUID.randomUUID(), "Jeremie", "Prince", "jeremie@email.com", "1234", Ruolo.AGRICOLTORE );

        //When
        doReturn( utente ).when( utenteRepositori ).save( any( Utente.class ) );

        when( objectMapper.dTOUtenteTOUtente( dtoUtente ) ).thenCallRealMethod();
        when( objectMapper.utenteTODTOUtente( utente ) ).thenCallRealMethod();

        DTOUtente candidateForEvaluation = utenteServices.createUtente( dtoUtente );

        //Then
        verify( utenteRepositori ).save( repositorySaveParamCaptor.capture() );
        verify( objectMapper ).dTOUtenteTOUtente( mapperParamDTOUtenteCaptor.capture() );
        verify( objectMapper ).utenteTODTOUtente( mapperParamUtenteCaptor.capture() );

        assertThat( candidateForEvaluation ).hasNoNullFieldsOrProperties();
        assertThat( candidateForEvaluation ).isExactlyInstanceOf( DTOUtente.class );
        assertThat( candidateForEvaluation.getIdUtente() ).isEqualTo( utente.getIdUtente() );
        assertThat( candidateForEvaluation.getEmail() ).isEqualTo( utente.getEmail() );


    }
}
