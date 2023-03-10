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
public class DTOSensore {

    private Long idSensore;
    private String descrizione;
    private String tipo;
    private String dateTime;
    private Long idSerra;

}
