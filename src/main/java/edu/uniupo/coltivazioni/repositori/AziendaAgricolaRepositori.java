package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.AziendaAgricola;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface AziendaAgricolaRepositori extends JpaRepository<AziendaAgricola, UUID> {
}
