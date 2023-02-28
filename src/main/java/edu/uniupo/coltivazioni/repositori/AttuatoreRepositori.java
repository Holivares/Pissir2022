package edu.uniupo.coltivazioni.repositori;

import edu.uniupo.coltivazioni.dao.Attuatore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author
 * @author
 */

/*JpaRepo permette di connettersi al DB e contiene tutte le operazione basiche del CRUD*/
@Repository
public interface AttuatoreRepositori extends JpaRepository<Attuatore, Long> {
}
