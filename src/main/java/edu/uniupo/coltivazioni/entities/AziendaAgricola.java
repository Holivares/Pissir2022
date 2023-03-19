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
@Table( name = "AGRICULTURAL_HOLDING")
public class AziendaAgricola implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_AGRICULTURAL_HOLDING" )
    private UUID idAziendaAgricola;
    @ManyToOne
    @JoinColumn( name = "ID_USER", referencedColumnName = "ID_USER" )
    private Utente utente;
    @Column( name = "NAME" )
    private String nome;
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
        AziendaAgricola that = ( AziendaAgricola ) o;
        return getIdAziendaAgricola() != null && Objects.equals( getIdAziendaAgricola(), that.getIdAziendaAgricola() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
