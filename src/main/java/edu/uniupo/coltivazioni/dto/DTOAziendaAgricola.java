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
/*creano in automatico costruttore, getters, setters*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DTOAziendaAgricola {

    private Long idAziendaAgricola;
    private String descrizione;
    private String tipo;
    private List<DTOSerra> serraList;
    private List<DTOUtente> utenteList;

}
