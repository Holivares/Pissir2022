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
public class DTOMisura {

    private Long idMisura;
    private String tipo;
    private String misurazioni;
    private String dateTime;
    private Long idSerra;

}
