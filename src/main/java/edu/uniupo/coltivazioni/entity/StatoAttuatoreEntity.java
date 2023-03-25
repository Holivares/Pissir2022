package edu.uniupo.coltivazioni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StatoAttuatoreEntity implements Serializable {

    @Enumerated( EnumType.STRING )
    @Column( name = "MODE" )
    private AttuatoreModeEntity mode;
    @Enumerated( EnumType.STRING )
    @Column( name = "STATUS" )
    private AttuatoreStatoEntity stato;
}
