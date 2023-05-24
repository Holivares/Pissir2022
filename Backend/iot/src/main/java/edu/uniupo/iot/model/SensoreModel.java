package edu.uniupo.iot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class SensoreModel {
    private UUID idSensore;
    private UUID idSerra;
    private TipoSensoreModel tipo;
}
