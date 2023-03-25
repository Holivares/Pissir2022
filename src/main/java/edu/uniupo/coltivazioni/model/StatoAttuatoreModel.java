package edu.uniupo.coltivazioni.model;

import edu.uniupo.coltivazioni.validator.EnumValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatoAttuatoreModel {
    @EnumValidation( clazz = AttuatoreModeModel.class, message = "Can't be arbitrary choose ! Allow choices: MANUALE or AUTOMATICO" )
    private AttuatoreModeModel mode;
    @EnumValidation( clazz = AttuatoreStatoModel.class, message = "Can't be arbitrary choose ! Allow choices: DISATTIVATO or ATTIVO" )
    private AttuatoreStatoModel stato;
}
