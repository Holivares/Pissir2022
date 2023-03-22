package edu.uniupo.coltivazioni.repositoriTests;

import edu.uniupo.coltivazioni.entities.AziendaAgricola;
import edu.uniupo.coltivazioni.entities.Ruolo;
import edu.uniupo.coltivazioni.entities.Utente;
import edu.uniupo.coltivazioni.repositori.AziendaAgricolaRepositori;
import edu.uniupo.coltivazioni.repositori.UtenteRepositori;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest( bootstrapMode = BootstrapMode.DEFERRED )
@ActiveProfiles( "test" )
public class RepositoriesCustomMethodTest {

    @Autowired
    private UtenteRepositori utenteRepositori;
    @Autowired
    private AziendaAgricolaRepositori aziendaAgricolaRepositori;
    private List<Utente> utenti;
    private List<AziendaAgricola> aziendaAgricole;

    @BeforeEach
    void setUp () {
        Utente utente1 = new Utente( "utente1", "test1", "test1@mail.com", "1234", Ruolo.AGRICOLTORE );
        Utente utente2 = new Utente( "utente2", "test2", "test2@mail.com", "1234", Ruolo.COLLABORATORE );

        utenti = utenteRepositori.saveAll( asList( utente1, utente2 ) );

        AziendaAgricola aziendaAgricola1 = new AziendaAgricola(
                utenti.get( 1 ), "azienda1", "this is a first azienda for my test implementation. have create this in beforeEach test method" );
        AziendaAgricola aziendaAgricola2 = new AziendaAgricola(
                utenti.get( 0 ), "azienda2", "this is second azienda for my test implementation. have create this in beforeEach test method" );

        aziendaAgricole = aziendaAgricolaRepositori.saveAll( asList( aziendaAgricola1, aziendaAgricola2 ) );

    }

    @AfterEach
    void afterEach () {
        utenteRepositori.deleteAll();
        aziendaAgricolaRepositori.deleteAll();
        utenti.clear();
        aziendaAgricole.clear();
    }

    @Test
    @DisplayName( "Test  for find user by him email" )
    void shouldFindUtenteByEmail () {

        String email = utenti.get( 0 ).getEmail();

        Optional<Utente> candidateToCheckExpect = utenteRepositori.findByEmail( email );

        assertThat( candidateToCheckExpect ).hasValueSatisfying( utente -> {
            assertThat( utente.getIdUtente() ).isExactlyInstanceOf( UUID.class );
            assertThat( utente.getNome() ).isEqualTo( utenti.get( 0 ).getNome() );
            assertThat( utente.getCognome() ).isEqualTo( utenti.get( 0 ).getCognome() );
            assertThat( utente.getEmail() ).isEqualTo( email );
            assertThat( utente.getPassword() ).isNotBlank();
            assertThat( utente.getRole().toString() ).isEqualTo( utenti.get( 0 ).getRole().toString() );
        } );
    }

    @Test
    void shouldFindAziendaAgricolaByIdUtente () {

        UUID idUtente = utenti.get( 1 ).getIdUtente();

        Optional<AziendaAgricola> candidateToExpected = aziendaAgricolaRepositori.findByUtenteIdUtente( idUtente );

        assertThat( candidateToExpected ).hasValueSatisfying( aziendaAgricola -> {
            assertThat( aziendaAgricola ).isExactlyInstanceOf( AziendaAgricola.class );
            assertThat( aziendaAgricola.getUtente().getIdUtente() ).isEqualTo( idUtente );
            assertThat( aziendaAgricola.getIdAziendaAgricola() ).isEqualTo( aziendaAgricole.get( 0 ).getIdAziendaAgricola() );
            assertThat( aziendaAgricola.getNome() ).isNotBlank();
            assertThat( aziendaAgricola.getDescrizione() ).isNotBlank();
        } );
    }

    @Test
    @Disabled
    void findAziendaAgricolaByHimNome () {
    }

    @Test
    @Disabled
    void shouldFindAziendaAgricolaByHimId () {
    }
}
