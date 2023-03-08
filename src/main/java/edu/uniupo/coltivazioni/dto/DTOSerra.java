package edu.uniupo.coltivazioni.dto;

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
    private Long idAziendaAgricola;

}
