package edu.uniupo.coltivazioni.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.uniupo.coltivazioni.validator.EnumValidation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttuatoreModel {
    @JsonProperty( access = JsonProperty.Access.READ_ONLY )
    private UUID idAttuatore;
    @NotBlank( message = "Can't be null or empty" )
    private UUID idSerra;
    @NotNull
    @Valid
    private StatoAttuatoreModel stato;
    @EnumValidation( clazz = TipoAttuatoreModel.class, message = "Can't be arbitrary choose ! Allow choices : ILLUMINAZIONE, RISCALDAMENTO or IRRIGAZIONE" )
    private TipoAttuatoreModel tipo;

}
