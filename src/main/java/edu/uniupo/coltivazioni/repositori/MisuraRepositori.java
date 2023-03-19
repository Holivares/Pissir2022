package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.Misura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author
 * @author
 */
@Repository
public interface MisuraRepositori extends JpaRepository<Misura, UUID> {
    Optional<Misura>findBySensoreIdSensore(UUID idSensore);

}
