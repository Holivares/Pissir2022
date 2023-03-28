package edu.uniupo.pissir.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class MisuraModel implements DefaultModel {
    private UUID idMisura;
    @NonNull
    @NotNull( message = "Id sensore  field can't be empty or null" )
    private UUID idSensore;
    @NonNull
    @NotNull( message = "Measure field can't be empty or null" )
    private BigDecimal misura;
}
