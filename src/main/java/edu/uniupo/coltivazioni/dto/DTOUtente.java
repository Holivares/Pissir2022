package edu.uniupo.coltivazioni.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DTOUtente {
    private Long idUtente;
    private String username;
    private String email;
    private String nome;
    private String cognome;
    private String ruolo;
    private Long idAziendaAgricola;
}
