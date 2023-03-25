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
@Table( name = "GREENHOUSE" )
public class SerraEntity implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_GREENHOUSE" )
    private UUID idSerra;
    @ManyToOne
    @JoinColumn( name = "ID_AGRICULTURAL_HOLDING" )
    private AziendaAgricolaEntity aziendaAgricolaEntity;
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
