package edu.uniupo.coltivazioni.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.uniupo.coltivazioni.constraints.EnumValidation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DTOAttuatore {
    @JsonProperty( access = JsonProperty.Access.READ_ONLY )
    private UUID idAttuatore;
    @NotBlank( message = "Can't be null or empty" )
    private UUID idSerra;
    @NotNull
    @Valid
    private DTOStatoAttuatore stato;
    @EnumValidation( clazz = DTOTipoAttuatore.class, message = "Can't be arbitrary choose ! Allow choices : ILLUMINAZIONE, RISCALDAMENTO or IRRIGAZIONE" )
    private DTOTipoAttuatore tipo;

}
