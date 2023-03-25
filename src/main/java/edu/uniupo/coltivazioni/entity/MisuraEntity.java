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
@Table( name = "MEASURE" )
public class MisuraEntity implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_MEASURE" )
    private UUID idMisura;
    @ManyToOne
    @JoinColumn( name = "ID_SENSOR" )
    private SensoreEntity sensoreEntity;
    @Column( name = "HUMIDITY_MEASURE", length = 4, precision = 2 )
    private Double umidita;
    @Column( name = "LIGHT_MEASURE", length = 4, precision = 2 )
    private Double luce;
    @Column( name = "TEMPERATURE_MEASURE", length = 4, precision = 2 )
    private Double temperatura;

    @Override
    public boolean equals ( Object o ) {
        if( this == o ) {
            return true;
        }
        if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) {
            return false;
        }
        MisuraEntity misuraEntity = ( MisuraEntity ) o;
        return getIdMisura() != null && Objects.equals( getIdMisura(), misuraEntity.getIdMisura() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
