package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.Serra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface SerraRepositori extends JpaRepository<Serra, UUID> {
}
