package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.entities.AttuatoreMode;
import edu.uniupo.coltivazioni.entities.AttuatoreStato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DTOStatoAttuatore {
    private AttuatoreMode mode;
    private AttuatoreStato stato;
}
