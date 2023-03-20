package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.entities.Utente;
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
public class DTOAziendaAgricola {
    private UUID idAziendaAgricola;
    private UUID idUtente;
    private String nome;
    private String descrizione;
}
