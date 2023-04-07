package edu.uniupo.iot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class MisuraRequestModel {
    private UUID idSensore;
    private BigDecimal misura;
}
