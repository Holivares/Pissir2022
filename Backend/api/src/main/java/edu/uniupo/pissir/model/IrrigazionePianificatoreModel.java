package edu.uniupo.pissir.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@ToString
@NoArgsConstructor( force = true )
@AllArgsConstructor
@RequiredArgsConstructor
public class IrrigazionePianificatoreModel implements DefaultModel {

    private UUID idIrrigazionePianificatore;
    @NonNull
    @NotNull( message = "Id azienda agricola field can't be empty or null" )
    private UUID idAziendaAgricola;
    @NonNull
    @NotNull( message = "Id serra field can't be empty or null" )
    private UUID idSerra;
    @NonNull
    @NotNull( message = "Description field can't be empty or null" )
    @NotBlank( message = "Description field can't be empty or null" )
    @Size( min = 10, max = 100, message = "Description field must contains 10 than 100 words length" )
    private String descrizione;
    @NonNull
    @NotNull( message = "field can't be empty or null" )
    private LocalDate esecuzioneData;
    @NonNull
    @NotNull( message = "field can't be empty or null" )
    private ExecutionTimeModel esecuzioneTempo;

}
