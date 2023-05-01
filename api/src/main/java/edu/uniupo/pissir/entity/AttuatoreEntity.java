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
@Table( name = "ACTUATOR" )
public class AttuatoreEntity implements Serializable {

    @Id
    @Column( name = "ID_ACTUATOR" )
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID idAttuatore;
    @NotNull
    @NonNull
    @ManyToOne(cascade = {CascadeType.REMOVE}, optional = false)
    @JoinColumn( name = "ID_GREENHOUSE" )
    private SerraEntity serraEntity;
    @NotNull
    @NonNull
    @Embedded
    private StatoAttuatoreEntity stato;
    @NotNull
    @NonNull
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
