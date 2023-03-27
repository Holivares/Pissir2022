package edu.uniupo.coltivazioni.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table( name = "MEASURE" )
public class MisuraEntity implements Serializable {

    @Id
    @Column( name = "ID_MEASURE" )
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID idMisura;
    @NotNull
    @NonNull
    @ManyToOne
    @JoinColumn( name = "ID_SENSOR" )
    private SensoreEntity sensoreEntity;
    @NotNull
    @NonNull
    @Column( name = "HUMIDITY_MEASURE", length = 4, precision = 2 )
    private BigDecimal misura;

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
