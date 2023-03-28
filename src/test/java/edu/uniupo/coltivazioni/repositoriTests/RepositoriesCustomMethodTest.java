package edu.uniupo.coltivazioni.repositoriTests;

import edu.uniupo.coltivazioni.entity.AziendaAgricolaEntity;
import edu.uniupo.coltivazioni.entity.RuoloEntity;
import edu.uniupo.coltivazioni.entity.UtenteEntity;
import edu.uniupo.coltivazioni.repository.AziendaAgricolaRepository;
import edu.uniupo.coltivazioni.repository.UtenteRepository;
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
    private UtenteRepository utenteRepository;
    @Autowired
    private AziendaAgricolaRepository aziendaAgricolaRepository;
    private List<UtenteEntity> utenti;
    private List<AziendaAgricolaEntity> aziendaAgricole;

    @BeforeEach
    void setUp () {
        UtenteEntity utenteEntity1 = new UtenteEntity( "utente1", "test1", "test1@mail.com", "1234", RuoloEntity.AGRICOLTORE );
        UtenteEntity utenteEntity2 = new UtenteEntity( "utente2", "test2", "test2@mail.com", "1234", RuoloEntity.COLLABORATORE );

        utenti = utenteRepository.saveAll( asList( utenteEntity1, utenteEntity2 ) );

        AziendaAgricolaEntity aziendaAgricolaEntity1 = new AziendaAgricolaEntity(
                utenti.get( 1 ), "azienda1", "this is a first azienda for my test implementation. have create this in beforeEach test method" );
        AziendaAgricolaEntity aziendaAgricolaEntity2 = new AziendaAgricolaEntity(
                utenti.get( 0 ), "azienda2", "this is second azienda for my test implementation. have create this in beforeEach test method" );

        aziendaAgricole = aziendaAgricolaRepository.saveAll( asList( aziendaAgricolaEntity1, aziendaAgricolaEntity2 ) );

    }

    @AfterEach
    void afterEach () {
        utenteRepository.deleteAll();
        aziendaAgricolaRepository.deleteAll();
        utenti.clear();
        aziendaAgricole.clear();
    }

    @Test
    @DisplayName( "Test  for find user by him email" )
    void shouldFindUtenteByEmail () {

        String email = utenti.get( 0 ).getEmail();

        Optional<UtenteEntity> candidateToCheckExpect = utenteRepository.findByEmail( email );

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

        Optional<AziendaAgricolaEntity> candidateToExpected = aziendaAgricolaRepository.findByUtenteEntityIdUtente( idUtente );

        assertThat( candidateToExpected ).hasValueSatisfying( aziendaAgricola -> {
            assertThat( aziendaAgricola ).isExactlyInstanceOf( AziendaAgricolaEntity.class );
            assertThat( aziendaAgricola.getUtenteEntity().getIdUtente() ).isEqualTo( idUtente );
            assertThat( aziendaAgricola.getIdAziendaAgricola() ).isEqualTo( aziendaAgricole.get( 0 ).getIdAziendaAgricola() );
            assertThat( aziendaAgricola.getNome() ).isNotBlank();
            assertThat( aziendaAgricola.getDescrizione() ).isNotBlank();
        } );
    }

    @Test
    void findAziendaAgricolaByHimNome () {
        String nome = aziendaAgricole.get(1).getNome();
        Optional<AziendaAgricolaEntity> candidateNomeToExcept = aziendaAgricolaRepository.findByNome(nome);
        assertThat(candidateNomeToExcept).hasValueSatisfying(aziendaAgricolaEntity -> {
            assertThat(aziendaAgricolaEntity).isExactlyInstanceOf(AziendaAgricolaEntity.class);
            assertThat( aziendaAgricolaEntity.getUtenteEntity().getNome()).isEqualTo(aziendaAgricole.get(1).getUtenteEntity().getNome());
            assertThat( aziendaAgricolaEntity.getIdAziendaAgricola() ).isEqualTo( aziendaAgricole.get( 1 ).getIdAziendaAgricola() );
            assertThat( aziendaAgricolaEntity.getDescrizione() ).isNotBlank();
        });

    }

    @Test
    void shouldFindAziendaAgricolaByHimId () {
        UUID idAziendaAgricola = aziendaAgricole.get(0).getIdAziendaAgricola();
        Optional<AziendaAgricolaEntity> candidateIdToExcept = aziendaAgricolaRepository.findById(idAziendaAgricola);
        assertThat(candidateIdToExcept).hasValueSatisfying(aziendaAgricolaEntity -> {
            assertThat(aziendaAgricolaEntity).isExactlyInstanceOf(AziendaAgricolaEntity.class);
            assertThat(aziendaAgricolaEntity.getIdAziendaAgricola()).isEqualTo(aziendaAgricole.get(0).getIdAziendaAgricola());
            assertThat(aziendaAgricolaEntity.getDescrizione()).isNotBlank();
        });
    }
}
