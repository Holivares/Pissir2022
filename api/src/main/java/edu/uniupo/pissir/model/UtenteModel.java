package edu.uniupo.pissir.model;

import edu.uniupo.pissir.validator.EnumValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UtenteModel implements DefaultModel {

    private UUID idUtente;
    @NonNull
    @NotNull( message = "Last name field can't be empty or null" )
    @NotBlank( message = "Last name field can't be empty or null" )
    @Size( min = 2, max = 25, message = "Last name must contains an word in length of 2 to 25 characters long" )
    private String nome;
    @NonNull
    @NotNull( message = "First name field can't be empty or null" )
    @NotBlank( message = "First name field can't be empty or null" )
    @Size( min = 2, max = 40, message = "First name must contains an word in length of 2 to 40 characters long" )
    private String cognome;
    @NonNull
    @Email( message = "email must contains a valid email" )
    @NotNull( message = "email field can't be empty or null" )
    @NotBlank( message = "email field can't be empty or null" )
    private String email;
    @NonNull
    @NotNull( message = "Password field can't be empty or null" )
    @NotBlank( message = "Password field can't be empty or null" )
    @Size( min = 4, max = 50, message = "Password must contains an word in length of 4 to 50 characters long" )
    private String password;
    @NonNull
    @NotNull( message = "Role field can't be empty or null" )
    @EnumValidation( clazz = RuoloModel.class, message = "Role field must be have AGRICOLTORE OR COLLABORATORE value" )
    private RuoloModel role;

}
