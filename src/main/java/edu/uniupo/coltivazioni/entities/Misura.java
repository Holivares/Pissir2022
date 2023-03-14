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
@Table( name = "MEASURE" )
public class Misura implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_MEASURE" )
    private UUID idMisura;
    @ManyToOne
    @JoinColumn( name = "ID_SENSOR", referencedColumnName = "ID_SENSOR" )
    private Sensore sensore;
    @Column( name = "HUMIDITY_MEASURE" )
    private Double umidita;
    @Column( name = "LIGHT_MEASURE" )
    private Double luce;
    @Column( name = "TEMPERATURE_MEASURE" )
    private Double temperatura;

    @Override
    public boolean equals ( Object o ) {
        if( this == o ) {
            return true;
        }
        if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) {
            return false;
        }
        Misura misura = ( Misura ) o;
        return getIdMisura() != null && Objects.equals( getIdMisura(), misura.getIdMisura() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
