package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.entities.AziendaAgricola;
import edu.uniupo.coltivazioni.entities.ExecutionTime;
import edu.uniupo.coltivazioni.entities.Serra;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author
 * @author
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DTOIrrigazionePianificatore {

    private UUID idIrrigazionePianificatore;
    private DTOAziendaAgricola aziendaAgricola;
    private DTOSerra serra;
    private String descrizione;
    private LocalDate esecuzioneData;
    private DTOExecutionTime esecuzioneTempo;

}
