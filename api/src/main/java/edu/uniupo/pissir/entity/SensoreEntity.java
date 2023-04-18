package edu.uniupo.pissir.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor( force = true )
@AllArgsConstructor
@RequiredArgsConstructor
@Table( name = "SENSOR" )
public class SensoreEntity implements Serializable {

    @Id
    @Column( name = "ID_SENSOR" )
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID idSensore;
    @NotNull
    @NonNull
    @ManyToOne
    @JoinColumn( name = "ID_GREENHOUSE" )
    private SerraEntity serraEntity;
    @NotNull
    @NonNull
    @Column( name = "TYPES" )
    @Enumerated( EnumType.STRING )
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
