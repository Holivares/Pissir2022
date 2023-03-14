package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.entities.Serra;
import edu.uniupo.coltivazioni.entities.TipoSensore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DTOSensore {
    private UUID idSensore;
    private Serra serra;
    private TipoSensore tipo;
}
