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
@Table( name = "SENSOR" )
public class SensoreEntity implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_SENSOR" )
    private UUID idSensore;
    @ManyToOne
    @JoinColumn( name = "ID_GREENHOUSE" )
    private SerraEntity serraEntity;
    @Enumerated( EnumType.STRING )
    @Column( name = "TYPE" )
    private TipoSensoreEntity tipo;

    @Override
    public boolean equals ( Object o ) {
        if( this == o ) {
            return true;
        }
        if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) {
            return false;
        }
        SensoreEntity sensoreEntity = ( SensoreEntity ) o;
        return getIdSensore() != null && Objects.equals( getIdSensore(), sensoreEntity.getIdSensore() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
