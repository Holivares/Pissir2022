package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.AziendaAgricola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author
 * @author
 */
@Repository
public interface AziendaAgricolaRepositori extends JpaRepository<AziendaAgricola, UUID> {
    Optional<AziendaAgricola> findByUtenteIdUtente ( UUID IdUtente );

    Optional<AziendaAgricola> findByNome ( String nome );
}
