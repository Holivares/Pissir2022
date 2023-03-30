package edu.uniupo.coltivazioni.repositoriTests;

import edu.uniupo.coltivazioni.entity.*;
import edu.uniupo.coltivazioni.model.SensoreModel;
import edu.uniupo.coltivazioni.repository.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest(bootstrapMode = BootstrapMode.DEFERRED)
@ActiveProfiles("test")
public class RepositoriesCustomMethodTest {

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private AziendaAgricolaRepository aziendaAgricolaRepository;
    @Autowired
    private SerraRepository serraRepository;
    @Autowired
    private SensoreRepository sensoreRepository;
    @Autowired
    private AttuatoreRepository attuatoreRepository;
    @Autowired
    private MisuraRepository misuraRepository;
    @Autowired
    private IrrigazionePianificatoreRepository pianificatoreRepository;
    private List<UtenteEntity> utenti;
    private List<AziendaAgricolaEntity> aziendaAgricole;
    private List<SerraEntity> serre;
    private List<SensoreEntity> sensori;
    private List<AttuatoreEntity> attuatori;
    private List<MisuraEntity> misure;
    private List<IrrigazionePianificatoreEntity> pianificatori;

    @BeforeEach
    void setUp() {
        //Instanzia di Utenti

        UtenteEntity utenteEntity1 = new UtenteEntity("utente1", "test1", "test1@mail.com", "1234", RuoloEntity.AGRICOLTORE);
        UtenteEntity utenteEntity2 = new UtenteEntity("utente2", "test2", "test2@mail.com", "1234", RuoloEntity.COLLABORATORE);

        utenti = utenteRepository.saveAll(asList(utenteEntity1, utenteEntity2));
        //Instanzia di Azienda agricola

        AziendaAgricolaEntity aziendaAgricolaEntity1 = new AziendaAgricolaEntity(
                utenti.get(1), "azienda1", "this is a first azienda for my test implementation. have create this in beforeEach test method");
        AziendaAgricolaEntity aziendaAgricolaEntity2 = new AziendaAgricolaEntity(
                utenti.get(0), "azienda2", "this is second azienda for my test implementation. have create this in beforeEach test method");

        aziendaAgricole = aziendaAgricolaRepository.saveAll(asList(aziendaAgricolaEntity1, aziendaAgricolaEntity2));
        //Instanzia di Serre

        SerraEntity serraEntity1 = new SerraEntity(aziendaAgricole.get(0), "this is a first serra for my test implementation...");
        SerraEntity serraEntity2 = new SerraEntity(aziendaAgricole.get(1), "this is a second serra for my test implementation...");

        serre = serraRepository.saveAll(asList(serraEntity1, serraEntity2));
        //Instanzia di Sensore

        SensoreEntity sensoreEntity1 = new SensoreEntity(serre.get(0), TipoSensoreEntity.LUCE);
        SensoreEntity sensoreEntity2 = new SensoreEntity(serre.get(1), TipoSensoreEntity.TEMPERATURA);

        sensori = sensoreRepository.saveAll(asList(sensoreEntity1, sensoreEntity2));
        //Instanzia di Attuatore

        AttuatoreEntity attuatoreEntity1 = new AttuatoreEntity(serre.get(0),new StatoAttuatoreEntity(AttuatoreModeEntity.MANUALE,AttuatoreStatoEntity.ATTIVO),TipoAttuatoreEntity.ILLUMINAZIONE );
        AttuatoreEntity attuatoreEntity2 = new AttuatoreEntity(serre.get(1),new StatoAttuatoreEntity(AttuatoreModeEntity.AUTOMATICO,AttuatoreStatoEntity.DISATTIVATO),TipoAttuatoreEntity.IRRIGAZIONE );

        attuatori = attuatoreRepository.saveAll(asList(attuatoreEntity1,attuatoreEntity2));

        //Instanzia di Misure

        MisuraEntity misuraEntity1 = new MisuraEntity(sensori.get(0), new BigDecimal("20"));
        MisuraEntity misuraEntity2 = new MisuraEntity(sensori.get(1), new BigDecimal("30"));
        misure = misuraRepository.saveAll(asList(misuraEntity1, misuraEntity2));
        //Instanzia di Irrigazione Pianificatore

        IrrigazionePianificatoreEntity pianificatore1 = new IrrigazionePianificatoreEntity(
                aziendaAgricole.get(0),serre.get(0),"Pianificatore1", LocalDate.of(2023, 4, 12),new ExecutionTimeEntity(LocalTime.of(12,20,00),LocalTime.of(16, 00, 25)));
        IrrigazionePianificatoreEntity pianificatore2 = new IrrigazionePianificatoreEntity(
                aziendaAgricole.get(0),serre.get(0),"Pianificatore2",LocalDate.of(2023, 8, 12), new ExecutionTimeEntity(LocalTime.of(06, 30,40),LocalTime.of(10, 40, 30)));

        pianificatori  = pianificatoreRepository.saveAll(asList(pianificatore1,pianificatore2));

    }

    @AfterEach
    void afterEach() {
        utenteRepository.deleteAll();
        aziendaAgricolaRepository.deleteAll();
        serraRepository.deleteAll();
        sensoreRepository.deleteAll();
        attuatoreRepository.deleteAll();
        misuraRepository.deleteAll();
        pianificatoreRepository.deleteAll();
        utenti.clear();
        aziendaAgricole.clear();
        serre.clear();
        sensori.clear();
        attuatori.clear();
        misure.clear();
        pianificatori.clear();
    }

    @Test
    @DisplayName("Test  for find user by him email")
    void shouldFindUtenteByEmail() {

        String email = utenti.get(0).getEmail();

        Optional<UtenteEntity> candidateToCheckExpect = utenteRepository.findByEmail(email);

        assertThat(candidateToCheckExpect).hasValueSatisfying(utente -> {
            assertThat(utente.getIdUtente()).isExactlyInstanceOf(UUID.class);
            assertThat(utente.getNome()).isEqualTo(utenti.get(0).getNome());
            assertThat(utente.getCognome()).isEqualTo(utenti.get(0).getCognome());
            assertThat(utente.getEmail()).isEqualTo(email);
            assertThat(utente.getPassword()).isNotBlank();
            assertThat(utente.getRole().toString()).isEqualTo(utenti.get(0).getRole().toString());
        });
    }

    @Test
    void shouldFindAziendaAgricolaByIdUtente() {

        UUID idUtente = utenti.get(1).getIdUtente();

        Optional<AziendaAgricolaEntity> candidateToExpect = aziendaAgricolaRepository.findByUtenteEntityIdUtente(idUtente);

        assertThat(candidateToExpect).hasValueSatisfying(aziendaAgricola -> {
            assertThat(aziendaAgricola).isExactlyInstanceOf(AziendaAgricolaEntity.class);
            assertThat(aziendaAgricola.getUtenteEntity().getIdUtente()).isEqualTo(idUtente);
            assertThat(aziendaAgricola.getIdAziendaAgricola()).isEqualTo(aziendaAgricole.get(0).getIdAziendaAgricola());
            assertThat(aziendaAgricola.getNome()).isNotBlank();
            assertThat(aziendaAgricola.getDescrizione()).isNotBlank();
        });
    }

    @Test
    void findAziendaAgricolaByHimNome() {
        String nome = aziendaAgricole.get(1).getNome();
        Optional<AziendaAgricolaEntity> candidateNomeToExcept = aziendaAgricolaRepository.findByNome(nome);
        assertThat(candidateNomeToExcept).hasValueSatisfying(aziendaAgricola -> {
            assertThat(aziendaAgricola).isExactlyInstanceOf(AziendaAgricolaEntity.class);
            assertThat(aziendaAgricola.getUtenteEntity().getNome()).isEqualTo(aziendaAgricole.get(1).getUtenteEntity().getNome());
            assertThat(aziendaAgricola.getIdAziendaAgricola()).isEqualTo(aziendaAgricole.get(1).getIdAziendaAgricola());
            assertThat(aziendaAgricola.getDescrizione()).isNotBlank();
        });

    }

    @Test
    void shouldFindAziendaAgricolaByHimId() {
        UUID idAziendaAgricola = aziendaAgricole.get(0).getIdAziendaAgricola();
        Optional<AziendaAgricolaEntity> candidateToExcept = aziendaAgricolaRepository.findById(idAziendaAgricola);
        assertThat(candidateToExcept).hasValueSatisfying(aziendaAgricola -> {
            assertThat(aziendaAgricola).isExactlyInstanceOf(AziendaAgricolaEntity.class);
            assertThat(aziendaAgricola.getIdAziendaAgricola()).isEqualTo(aziendaAgricole.get(0).getIdAziendaAgricola());
            assertThat(aziendaAgricola.getDescrizione()).isNotBlank();
        });
    }

    @Test
    void shouldFindSerraByIdAziendaAgricola() {
        UUID idAziendaAgricola = aziendaAgricole.get(0).getIdAziendaAgricola();
        Optional<List<SerraEntity>> condidateToExcept = serraRepository.findByAziendaAgricolaEntityIdAziendaAgricola(idAziendaAgricola);
        assertThat(condidateToExcept).hasValueSatisfying(serraList -> {
            assertThat(serraList.get(0)).isExactlyInstanceOf(SerraEntity.class);
            assertThat(serraList.get(0).getAziendaAgricolaEntity().getIdAziendaAgricola()).isEqualTo(idAziendaAgricola);
            assertThat(serraList.get(0).getDescrizione()).isNotBlank();
        });
    }

    @Test
    void shouldFindSensoreByIdSerra() {

        UUID idSerra = serre.get(0).getIdSerra();
        Optional<List<SensoreEntity>> condidateToExcept = sensoreRepository.findBySerraEntityIdSerra(idSerra);
        assertThat(condidateToExcept).hasValueSatisfying(sensoreList -> {
            assertThat(sensoreList.get(0)).isExactlyInstanceOf(SensoreEntity.class);
            assertThat(sensoreList.get(0).getTipo()).isEqualTo(sensori.get(0).getTipo());
            assertThat(sensoreList.get(0).getSerraEntity().getIdSerra()).isEqualTo(idSerra);
        });
    }

    @Test
    void shouldFindAttuatoreByIdSerra() {

        UUID idSerra = serre.get(0).getIdSerra();
        Optional<List<AttuatoreEntity>>candidateToExcept = attuatoreRepository.findBySerraEntityIdSerra(idSerra);
        assertThat(candidateToExcept).hasValueSatisfying(attuatoreList -> {
            assertThat(attuatoreList.get(0)).isExactlyInstanceOf(AttuatoreEntity.class);
            assertThat(attuatoreList.get(0).getStato()).isEqualTo(attuatori.get(0).getStato());
            assertThat(attuatoreList.get(0).getTipo()).isEqualTo(attuatori.get(0).getTipo());
            assertThat(attuatoreList.get(0).getSerraEntity().getIdSerra()).isEqualTo(idSerra);
        });
    }

    @Test
    void shouldEnableAttuatore() {
        UUID idAttuatore = attuatori.get(1).getIdAttuatore();
        Optional<AttuatoreEntity> candidateToExcept = attuatoreRepository.findById(idAttuatore);
        assertThat(candidateToExcept).hasValueSatisfying(attuatore -> {
            assertThat(attuatore).isExactlyInstanceOf(AttuatoreEntity.class);
            assertThat(attuatore.getIdAttuatore()).isEqualTo(idAttuatore);
            assertThat(attuatore.getStato().getStato()).isEqualTo(AttuatoreStatoEntity.DISATTIVATO);
        });
    }

    @Test
    void shouldDisableAttuatore() {
        UUID idAttuatore = attuatori.get(0).getIdAttuatore();
        Optional<AttuatoreEntity> candidateToExcept = attuatoreRepository.findById(idAttuatore);
        assertThat(candidateToExcept).hasValueSatisfying(attuatore -> {
            assertThat(attuatore).isExactlyInstanceOf(AttuatoreEntity.class);
            assertThat(attuatore.getIdAttuatore()).isEqualTo(idAttuatore);
            assertThat(attuatore.getStato().getStato()).isEqualTo(AttuatoreStatoEntity.ATTIVO);
        });
    }

    @Test
    void shouldFindMisuraByHimId() {
        UUID idMisura = misure.get(0).getIdMisura();
        Optional<MisuraEntity> candidateToExcept = misuraRepository.findById(idMisura);
        assertThat(candidateToExcept).hasValueSatisfying(misura -> {
            assertThat(misura).isExactlyInstanceOf(MisuraEntity.class);
            assertThat(misura.getIdMisura()).isEqualTo(misure.get(0).getIdMisura());
        });
    }

    @Test
    void shouldFindMisuraBySensoreId() {

        UUID idSensore = sensori.get(0).getIdSensore();
        Optional<List<MisuraEntity>> candidateToExcept = misuraRepository.findBySensoreEntityIdSensore(idSensore);
        assertThat(candidateToExcept).hasValueSatisfying(misuraList -> {
            assertThat(misuraList.get(0)).isExactlyInstanceOf(MisuraEntity.class);
            assertThat(misuraList.get(0).getSensoreEntity().getIdSensore()).isEqualTo(idSensore);
            assertThat(misuraList.get(0).getMisura()).isEqualTo(misure.get(0).getMisura());

        });
    }
    @Test
    void shouldFindIrrigazionePianificatoreByIdAziendaAgricola(){
        UUID idAziendaAgricola = aziendaAgricole.get(0).getIdAziendaAgricola();
        Optional<List<IrrigazionePianificatoreEntity>> candidateToExcept = pianificatoreRepository.findByAziendaAgricolaEntityIdAziendaAgricola(idAziendaAgricola);
        assertThat(candidateToExcept).hasValueSatisfying(irrigazionePianificatore ->{
            assertThat(irrigazionePianificatore.get(0)).isExactlyInstanceOf(IrrigazionePianificatoreEntity.class);
            assertThat(irrigazionePianificatore.get(0).getAziendaAgricolaEntity().getIdAziendaAgricola()).isEqualTo(idAziendaAgricola);
            assertThat(irrigazionePianificatore.get(0).getDescrizione()).isNotBlank();
            assertThat(irrigazionePianificatore.get(0).getEsecuzioneTempo()).isEqualTo(pianificatori.get(0).getEsecuzioneTempo());
            assertThat(irrigazionePianificatore.get(0).getEsecuzioneData()).isEqualTo(pianificatori.get(0).getEsecuzioneData());
        } );

    }
    @Test
    void shouldFindIrrigazionePianificatoreByIdserra(){
        System.out.println(serre.size());
        UUID idSerra = serre.get(0).getIdSerra();
        Optional<List<IrrigazionePianificatoreEntity>>candidateToExcept = pianificatoreRepository.findBySerraEntityIdSerra(idSerra);
        assertThat(candidateToExcept).hasValueSatisfying(irrigazionePianificatore ->{
            System.out.println(irrigazionePianificatore.size());
            assertThat(irrigazionePianificatore.get(0)).isExactlyInstanceOf(IrrigazionePianificatoreEntity.class);
            assertThat(irrigazionePianificatore.get(0).getDescrizione()).isNotBlank();
            assertThat(irrigazionePianificatore.get(0).getEsecuzioneTempo()).isEqualTo(pianificatori.get(0).getEsecuzioneTempo());
            assertThat(irrigazionePianificatore.get(0).getEsecuzioneData()).isEqualTo(pianificatori.get(0).getEsecuzioneData());
        } );


    }

}

