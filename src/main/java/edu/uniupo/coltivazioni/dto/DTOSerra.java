package edu.uniupo.coltivazioni.dto;

import lombok.*;

import java.util.List;

/**
 * @author
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DTOSerra {

    private Long idSerra;
    private List<DTOAttuatore> attuatore;
    private List<DTOMisura> misura;
    private List<DTOSensore> sensore;
    private String descrizione;
    private String tipoColtura;
    private Long idAziendaAgricola;

}
