package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOMisura;

import java.util.UUID;

/**
 * @author
 * @author
 */
public interface MisuraServices {

    DTOMisura createMisura ( DTOMisura dtoMisura );

    DTOMisura findMisuraById ( UUID idMisura );

    DTOMisura findMisuraBySensoreId ( UUID idSensore );
}
