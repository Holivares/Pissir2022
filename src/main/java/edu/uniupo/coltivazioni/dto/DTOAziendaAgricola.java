package edu.uniupo.coltivazioni.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

/**
 * @author
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class DTOAziendaAgricola {
    @JsonProperty( access = JsonProperty.Access.READ_ONLY )
    private UUID idAziendaAgricola;
    @NotBlank( message = "Field can't be empty or null" )
    @NonNull
    private UUID idUtente;
    @NotBlank( message = "Field can't be empty or null" )
    @NonNull
    @Size( min = 2, max = 25, message = "Must contains an word in length of 2 to 25 characters long" )
    private String nome;
    @NotBlank( message = "Field can't be empty or null" )
    @NonNull
    @Size( min = 25, max = 100, message = "Must contains an word in length of 25 to 100 characters long" )
    private String descrizione;
}
