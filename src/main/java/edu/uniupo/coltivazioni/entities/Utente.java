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
@Table( name = "PERSON" )
public class Utente implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_USER" )
    private UUID idUtente;
    @Column( name = "NAME", length = 25 )
    private String nome;
    @Column( name = "FIRST_NAME", length = 25 )
    private String cognome;
    @Column( name = "EMAIL", length = 25 )
    private String email;
    @Column( name = "PASSWORD", length = 25 )
    private String password;
    @Column( name = "ROLE", length = 25 )
    @Enumerated( EnumType.STRING )
    private Ruolo role;

    @Override
    public boolean equals ( Object o ) {
        if( this == o ) {
            return true;
        }
        if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) {
            return false;
        }
        Utente utente = ( Utente ) o;
        return getIdUtente() != null && Objects.equals( getIdUtente(), utente.getIdUtente() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
