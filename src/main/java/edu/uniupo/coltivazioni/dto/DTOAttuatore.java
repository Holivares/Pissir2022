package edu.uniupo.coltivazioni.dto;

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
public class DTOAttuatore {

    private Long idAttuatore;
    private String descrizione;
    private String stato;
    private boolean isManual;
    private Long idSerra;

}
