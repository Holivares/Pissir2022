package edu.uniupo.coltivazioni.model;

import edu.uniupo.coltivazioni.validator.EnumValidation;
import jakarta.validation.constraints.Email;
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
public class UtenteModel implements ModelType {

    private UUID idUtente;
    @Size( min = 2, max = 25, message = "Last name must contains an word in length of 2 to 25 characters long" )
    @NotBlank( message = "Last name field can't be empty or null" )
    @NotNull( message = "Last name field can't be empty or null" )
    @NonNull
    private String nome;
    @Size( min = 2, max = 40, message = "First name must contains an word in length of 2 to 40 characters long" )
    @NotBlank( message = "First name field can't be empty or null" )
    @NotNull( message = "First name field can't be empty or null" )
    @NonNull
    private String cognome;
    @NotBlank( message = "email field can't be empty or null" )
    @Email( message = "email must contains a valid email" )
    @NotNull( message = "email field can't be empty or null" )
    @NonNull
    private String email;
    @Size( min = 4, max = 50, message = "Password must contains an word in length of 4 to 50 characters long" )
    @NotBlank( message = "Password field can't be empty or null" )
    @NotNull( message = "Password field can't be empty or null" )
    @NonNull
    private String password;
    @EnumValidation( clazz = RuoloModel.class, message = "Role field must be have AGRICOLTORE OR COLLABORATORE value" )
    @NotNull( message = "Role field can't be empty or null" )
    @NonNull
    private RuoloModel role;

}
