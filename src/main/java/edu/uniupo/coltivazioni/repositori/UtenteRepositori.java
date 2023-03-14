package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface UtenteRepositori extends JpaRepository<Utente, UUID> {
}
