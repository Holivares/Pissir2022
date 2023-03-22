package edu.uniupo.coltivazioni.dto;

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
    private UUID idAziendaAgricola;
    private UUID idSerra;
    private String descrizione;
    private LocalDate esecuzioneData;
    private DTOExecutionTime esecuzioneTempo;

}
