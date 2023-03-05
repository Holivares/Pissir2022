package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Attuatore;
import edu.uniupo.coltivazioni.dto.DTOAttuatore;

/**
 * @author
 * @author
 */
public interface AttuatoreServices {
    DTOAttuatore getAttuatore(Long idAttuatore);

    DTOAttuatore saveAttuatore(DTOAttuatore dtoAttuatore);
}
