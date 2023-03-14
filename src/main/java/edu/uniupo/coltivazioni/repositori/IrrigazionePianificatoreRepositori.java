package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.IrrigazionePianificatore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface IrrigazionePianificatoreRepositori extends JpaRepository<IrrigazionePianificatore, UUID> {
}
