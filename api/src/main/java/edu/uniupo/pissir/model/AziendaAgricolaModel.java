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
public class AziendaAgricolaModel implements DefaultModel {

    private UUID idAziendaAgricola;
    @NonNull
    @NotNull( message = "User id field can't be empty or null" )
    private UUID idUtente;
    @NonNull
    @NotNull( message = "User field can't be empty or null" )
    @NotBlank( message = "User field can't be empty or null" )
    @Size( min = 2, max = 25, message = "Name Field must contains an word in length of 2 to 25 characters long" )
    private String nome;
    @NonNull
    @NotNull( message = "Description field can't be empty or null" )
    @NotBlank( message = "Description field can't be empty or null" )
    @Size( min = 10, max = 100, message = "Description must contains an word in length of 25 to 100 characters long" )
    private String descrizione;
}
