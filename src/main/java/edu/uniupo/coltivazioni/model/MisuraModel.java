package edu.uniupo.coltivazioni.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MisuraModel {
    private UUID idMisura;
    private UUID idSensore;
    private Double umidita;
    private Double luce;
    private Double temperatura;
}
