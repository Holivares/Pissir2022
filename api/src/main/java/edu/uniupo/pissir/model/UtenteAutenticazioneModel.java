package edu.uniupo.pissir.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UtenteAutenticazioneModel implements DefaultModel {
    @NonNull
    @Email( message = "Authentication has failed" )
    @NotNull( message = "Email field can't be empty or null" )
    @NotBlank( message = "Email field can't be empty or null" )
    private String email;
    @NonNull
    @NotNull( message = "Password field can't be empty or null" )
    @NotBlank( message = "Password field can't be empty or null" )
    @Size( min = 4, max = 50, message = "Authentication has failed" )
    private String password;
}
