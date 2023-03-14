package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.entities.AziendaAgricola;
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
public class DTOSerra {
    private UUID idSerra;
    private AziendaAgricola aziendaAgricola;
    private String descrizione;
}
