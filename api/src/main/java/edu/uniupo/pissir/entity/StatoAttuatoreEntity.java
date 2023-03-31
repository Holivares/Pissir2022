package edu.uniupo.pissir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Embeddable
@NoArgsConstructor
public class StatoAttuatoreEntity implements Serializable {

    @NotNull
    @Column( name = "MODE" )
    @Enumerated( EnumType.STRING )
    private AttuatoreModeEntity mode;
    @NotNull
    @Column( name = "STATUS" )
    @Enumerated( EnumType.STRING )
    private AttuatoreStatoEntity stato;
}