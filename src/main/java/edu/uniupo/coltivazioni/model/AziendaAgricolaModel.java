package edu.uniupo.coltivazioni.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class AziendaAgricolaModel implements DefaultModel {

    private UUID idAziendaAgricola;
    @NotNull( message = "User id field can't be empty or null" )
    @NonNull
    private UUID idUtente;
    @Size( min = 2, max = 25, message = "Name Field must contains an word in length of 2 to 25 characters long" )
    @NotBlank( message = "User field can't be empty or null" )
    @NotNull( message = "User field can't be empty or null" )
    @NonNull
    private String nome;
    @Size( min = 50, max = 100, message = "Description must contains an word in length of 25 to 100 characters long" )
    @NotBlank( message = "Description field can't be empty or null" )
    @NotNull( message = "Description field can't be empty or null" )
    @NonNull
    private String descrizione;
}
