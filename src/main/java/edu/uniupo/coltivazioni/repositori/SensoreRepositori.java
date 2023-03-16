package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.Sensore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author
 * @author
 */
@Repository
public interface SensoreRepositori extends JpaRepository<Sensore, UUID> {
}
