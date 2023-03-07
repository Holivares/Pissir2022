package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.dao.Serra;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private int idAttuatore;

    private String descrizione;

    private String stato;
    private boolean isManual;
    private DTOSerra serra;
}
