package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.entities.Sensore;
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
public class DTOMisura {
    private UUID idMisura;
    private DTOSensore sensore;
    private Double umidita;
    private Double luce;
    private Double temperatura;
}
