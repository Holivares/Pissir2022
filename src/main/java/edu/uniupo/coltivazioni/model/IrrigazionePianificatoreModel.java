package edu.uniupo.coltivazioni.model;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IrrigazionePianificatoreModel {

    private UUID idIrrigazionePianificatore;
    private UUID idAziendaAgricola;
    private UUID idSerra;
    private String descrizione;
    private LocalDate esecuzioneData;
    private ExecutionTimeModel esecuzioneTempo;

}
