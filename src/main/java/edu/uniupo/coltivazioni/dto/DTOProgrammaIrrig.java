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
public class DTOProgrammaIrrig {

    private Long idProgramma;
    private String dateTime;
    private int oraInizio;
    private int oraFine;
    private String descrizione;
    private DTOTipoProgramma tipo;

}
