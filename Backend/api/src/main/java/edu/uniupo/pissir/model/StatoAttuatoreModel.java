package edu.uniupo.pissir.model;

import edu.uniupo.pissir.validator.EnumValidation;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatoAttuatoreModel implements DefaultModel {
    @NotNull
    @EnumValidation( clazz = AttuatoreModeModel.class, message = "Can't be arbitrary choose ! Allow choices: MANUALE or AUTOMATICO" )
    private AttuatoreModeModel mode;
    @NotNull
    @EnumValidation( clazz = AttuatoreStatoModel.class, message = "Can't be arbitrary choose ! Allow choices: DISATTIVATO or ATTIVO" )
    private AttuatoreStatoModel stato;
}
