package edu.uniupo.coltivazioni.dto;

import lombok.*;

import java.util.List;

/**
 * @author
 * @author
 */
/*creano in automatico costruttore, getters, setters*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DTOAziendaAgricola {

    private Long idAziendaAgricola;
    private String descrizione;
    private String tipo;
    private List<DTOSerra> serraList;
    private List<DTOUtente> utenteList;

}
