package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.Serra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author
 * @author
 */
@Repository
public interface SerraRepositori extends JpaRepository<Serra, UUID> {
    Optional<Serra> findByAziendaAgricolaIdAziendaAgricola ( UUID idAziendaAgricola );
}
