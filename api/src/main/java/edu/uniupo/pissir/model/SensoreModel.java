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
public class SensoreModel implements DefaultModel {
    private UUID idSensore;
    @NonNull
    @NotNull( message = "Id serra field can't be null or empty" )
    private UUID idSerra;
    @NonNull
    @NotNull( message = "Tipo field can't be null or empty" )
    @EnumValidation( clazz = TipoSensoreModel.class, message = "Tipo field must be have value between : LUCE, TEMPERATURA or UMIDITA" )
    private TipoSensoreModel tipo;
}
