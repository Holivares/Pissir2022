package edu.uniupo.pissir.model;

import edu.uniupo.pissir.validator.EnumValidation;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor( force = true )
@AllArgsConstructor
@RequiredArgsConstructor
public class AttuatoreModel implements DefaultModel {

    private UUID idAttuatore;
    @NonNull
    @NotNull( message = "Id serra field can't be null or empty" )
    private UUID idSerra;
    @NonNull
    @NotNull( message = "Status field can't be empty or null" )
    private StatoAttuatoreModel stato;
    @NonNull
    @NotNull( message = "Tipo field can't be empty or null" )
    @EnumValidation( clazz = TipoAttuatoreModel.class, message = "Tipo field Allow choices : ILLUMINAZIONE, RISCALDAMENTO or IRRIGAZIONE" )
    private TipoAttuatoreModel tipo;

}
