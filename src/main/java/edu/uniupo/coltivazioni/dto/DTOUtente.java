package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.entities.Ruolo;
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
public class DTOUtente {
    private UUID idUtente;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private DTORuolo role;
}
