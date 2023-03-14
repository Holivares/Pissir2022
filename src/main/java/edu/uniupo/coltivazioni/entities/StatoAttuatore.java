package edu.uniupo.coltivazioni.entities;

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
public class StatoAttuatore implements Serializable {

    @Enumerated( EnumType.STRING )
    @Column( name = "MODE" )
    private AttuatoreMode mode;
    @Enumerated( EnumType.STRING )
    @Column( name = "STATUS" )
    private AttuatoreStato stato;
}
