package edu.uniupo.coltivazioni.dto;

import edu.uniupo.coltivazioni.constraints.EnumValidation;
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
public class DTOStatoAttuatore {
    @EnumValidation( clazz = DTOAttuatoreMode.class, message = "Can't be arbitrary choose ! Allow choices: MANUALE or AUTOMATICO" )
    private DTOAttuatoreMode mode;
    @EnumValidation( clazz = DTOAttuatoreStato.class, message = "Can't be arbitrary choose ! Allow choices: DISATTIVATO or ATTIVO" )
    private DTOAttuatoreStato stato;
}
