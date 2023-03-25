package edu.uniupo.coltivazioni.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UtenteAutenticazioneModel implements ModelType {
    @Email( message = "Authentication has failed" )
    @NotBlank( message = "Email field can't be empty or null" )
    @NotNull( message = "Email field can't be empty or null" )
    @NonNull
    private String email;
    @Size( min = 4, max = 50, message = "Authentication has failed" )
    @NotBlank( message = "Password field can't be empty or null" )
    @NotNull( message = "Password field can't be empty or null" )
    @NonNull
    private String password;
}
