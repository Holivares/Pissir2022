package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.entities.IrrigazionePianificatore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author
 * @author
 */
@Repository
public interface IrrigazionePianificatoreRepositori extends JpaRepository<IrrigazionePianificatore, UUID> {
}
