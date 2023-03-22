package edu.uniupo.coltivazioni.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.uniupo.coltivazioni.constraints.EnumValidation;
import jakarta.validation.constraints.Email;
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
public class DTOUtente {

    @JsonProperty( access = JsonProperty.Access.READ_ONLY )
    private UUID idUtente;
    @NotBlank( message = "Field can't be empty or null" )
    @NonNull
    @Size( min = 2, max = 25, message = "Must contains an word in length of 2 to 25 characters long" )
    private String nome;
    @NotBlank( message = "Field can't be empty or null" )
    @NonNull
    @Size( min = 2, max = 40, message = "Must contains an word in length of 2 to 40 characters long" )
    private String cognome;
    @Email( message = "Must contains a valid email" )
    @NotBlank( message = "Field can't be empty or null" )
    @NonNull
    private String email;
    @NotBlank( message = "Field can't be empty or null" )
    @NonNull
    @Size( min = 4, max = 50, message = "Must contains an word in length of 2 to 25 characters long" )
    private String password;
    @NotBlank( message = "Field can't be empty or null" )
    @EnumValidation( clazz = DTORuolo.class, message = "Must be have AGRICOLTORE OR COLLABORATORE value" )
    @NonNull
    private DTORuolo role;
}
