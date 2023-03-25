package edu.uniupo.coltivazioni.entity;

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
public class AttuatoreEntity implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_ACTUATOR" )
    private UUID idAttuatore;
    @ManyToOne
    @JoinColumn( name = "ID_GREENHOUSE" )
    private SerraEntity serraEntity;
    @Embedded
    private StatoAttuatoreEntity stato;
    @Enumerated( EnumType.STRING )
    @Column( name = "TYPE", length = 25 )
    private TipoAttuatoreEntity tipo;

    @Override
    public boolean equals ( Object o ) {
        if( this == o ) {
            return true;
        }
        if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) {
            return false;
        }
        AttuatoreEntity attuatoreEntity = ( AttuatoreEntity ) o;
        return getIdAttuatore() != null && Objects.equals( getIdAttuatore(), attuatoreEntity.getIdAttuatore() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
