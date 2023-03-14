package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.entities.Serra;
import edu.uniupo.coltivazioni.entities.StatoAttuatore;
import edu.uniupo.coltivazioni.entities.TipoAttuatore;
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
public class DTOAttuatore {
    private UUID idAttuatore;

    private Serra serra;

    private StatoAttuatore stato;

    private TipoAttuatore typa;

}
