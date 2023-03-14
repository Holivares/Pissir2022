package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.Attuatore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface AttuatoreRepositori extends JpaRepository<Attuatore, UUID> {
}
