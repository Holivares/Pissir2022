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

import java.util.Date;

/**
 * @author
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DTOSensore {

    private Long idSensore;

    private String descrizione;

    private String tipo;

    private String dateTime;
    private Serra serra;
}
