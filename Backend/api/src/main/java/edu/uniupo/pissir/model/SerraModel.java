package edu.uniupo.pissir.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor( force = true )
@AllArgsConstructor
@RequiredArgsConstructor
public class SerraModel implements DefaultModel {
    private UUID idSerra;
    @NonNull
    @NotNull( message = "Azienda agricola id field can't be empty or null" )
    private UUID idAziendaAgricola;
    @NonNull
    @NotNull( message = "Description field can't be empty or null" )
    @NotBlank( message = "Description field can't be empty or null" )
    @Size( min = 50, max = 100, message = "Description must contains an word in length of 25 to 100 characters long" )
    private String descrizione;
}
