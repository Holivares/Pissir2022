package edu.uniupo.coltivazioni.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "ACTUATOR" )
public class Attuatore implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_ACTUATOR" )
    private UUID idAttuatore;
    @ManyToOne
    @JoinColumn( name = "ID_GREENHOUSE" )
    private Serra serra;
    @Embedded
    private StatoAttuatore stato;
    @Enumerated( EnumType.STRING )
    @Column( name = "TYPE" )
    private TipoAttuatore tipo;

    @Override
    public boolean equals ( Object o ) {
        if( this == o ) {
            return true;
        }
        if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) {
            return false;
        }
        Attuatore attuatore = ( Attuatore ) o;
        return getIdAttuatore() != null && Objects.equals( getIdAttuatore(), attuatore.getIdAttuatore() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
