package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.dao.Serra;
import edu.uniupo.coltivazioni.dao.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
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
