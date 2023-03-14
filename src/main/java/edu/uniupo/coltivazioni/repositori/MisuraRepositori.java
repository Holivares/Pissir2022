package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.Misura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface MisuraRepositori extends JpaRepository<Misura, UUID> {
}
