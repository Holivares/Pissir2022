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
@Table( name = "GREENHOUSE" )
public class Serra implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_GREENHOUSE" )
    private UUID idSerra;
    @ManyToOne
    @JoinColumn( name = "ID_AGRICULTURAL_HOLDING", referencedColumnName = "ID_AGRICULTURAL_HOLDING" )
    private AziendaAgricola aziendaAgricola;
    @Column( name = "DESCRIPTION" )
    private String descrizione;

    @Override
    public boolean equals ( Object o ) {
        if( this == o ) {
            return true;
        }
        if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) {
            return false;
        }
        Serra serra = ( Serra ) o;
        return getIdSerra() != null && Objects.equals( getIdSerra(), serra.getIdSerra() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
