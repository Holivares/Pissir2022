package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author
 * @author
 */
@Repository
public interface UtenteRepositori extends JpaRepository<Utente, UUID> {
    Optional<Utente> findByEmailAndPassword(String email, String password);
}
