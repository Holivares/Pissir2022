package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.dao.Serra;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

/**
 * @author
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DTOMisura {
    private Long idMisura;

    private String tipo;

    private String misurazioni;

    private String dateTime;
    private Serra serra;
}
