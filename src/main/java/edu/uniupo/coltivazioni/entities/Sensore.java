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
@Table( name = "SENSOR" )
public class Sensore implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_SENSOR" )
    private UUID idSensore;
    @ManyToOne
    @JoinColumn( name = "ID_GREENHOUSE", referencedColumnName = "ID_GREENHOUSE" )
    private Serra serra;
    @Enumerated( EnumType.STRING )
    @Column( name = "TYPE" )
    private TypaSensore typa;

    @Override
    public boolean equals ( Object o ) {
        if( this == o ) {
            return true;
        }
        if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) {
            return false;
        }
        Sensore sensore = ( Sensore ) o;
        return getIdSensore() != null && Objects.equals( getIdSensore(), sensore.getIdSensore() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
