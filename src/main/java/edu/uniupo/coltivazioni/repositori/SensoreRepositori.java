package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.Sensore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface SensoreRepositori extends JpaRepository<Sensore, UUID> {
}
