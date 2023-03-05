package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.dao.Attuatore;
import edu.uniupo.coltivazioni.dao.AziendaAgricola;
import edu.uniupo.coltivazioni.dao.Misura;
import edu.uniupo.coltivazioni.dao.Sensore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DTOSerra {
    private Long idSerra;

    private List<DTOAttuatore> attuatore;
    private List<DTOMisura> misura;

    private List<DTOSensore> sensore;
    private String descrizione;
    private String tipoColtura;
    private DTOAziendaAgricola aziendaAgricola;
}
