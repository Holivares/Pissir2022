package edu.uniupo.pissir.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table( name = "GREENHOUSE" )
public class SerraEntity implements Serializable {

    @Id
    @Column( name = "ID_GREENHOUSE" )
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID idSerra;
    @NotNull
    @NonNull
    @ManyToOne
    @JoinColumn( name = "ID_AGRICULTURAL_HOLDING" )
    private AziendaAgricolaEntity aziendaAgricolaEntity;
    @NotNull
    @NonNull
    @NotBlank
    @Column( name = "DESCRIPTION", length = 100 )
    private String descrizione;

    @Override
    public boolean equals ( Object o ) {
        if( this == o ) {
            return true;
        }
        if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) {
            return false;
        }
        SerraEntity serraEntity = ( SerraEntity ) o;
        return getIdSerra() != null && Objects.equals( getIdSerra(), serraEntity.getIdSerra() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
