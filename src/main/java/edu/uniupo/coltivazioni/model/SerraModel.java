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
public class SerraModel implements DefaultModel {
    private UUID idSerra;
    @NotNull( message = "Azienda agricola id field can't be empty or null" )
    @NonNull
    private UUID idAziendaAgricola;
    @Size( min = 50, max = 100, message = "Description must contains an word in length of 25 to 100 characters long" )
    @NotBlank( message = "Description field can't be empty or null" )
    @NotNull( message = "Description field can't be empty or null" )
    @NonNull
    private String descrizione;
}
