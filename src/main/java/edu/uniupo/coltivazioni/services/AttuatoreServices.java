package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOAttuatore;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;

/**
 * @author
 * @author
 */
public interface AttuatoreServices {
    DTOAttuatore getAttuatore ( Long idAttuatore );

    DTOAttuatore saveAttuatore ( DTOAttuatore dtoAttuatore );

    DTOAttuatore updateAttuatore ( DTOAttuatore dtoAttuatore );

    DTODeletedResponse deleteAttuatore ( Long idAttuatore );
}
