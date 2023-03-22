package edu.uniupo.coltivazioni.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
@RequiredArgsConstructor
@Entity
@Table( name = "PERSON", uniqueConstraints = @UniqueConstraint( columnNames = { "EMAIL" } ) )
public class Utente implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_USER", length = 10 )
    private UUID idUtente;
    @Column( name = "NAME", length = 25 )
    @NonNull
    @NotBlank
    private String nome;
    @Column( name = "FIRST_NAME", length = 40 )
    @NonNull
    @NotBlank
    private String cognome;
    @Column( name = "EMAIL", length = 50 )
    @NonNull
    @Email
    @NotBlank
    private String email;
    @Column( name = "PASSWORD", length = 55 )
    @NonNull
    @NotBlank
    private String password;
    @Column( name = "ROLE" )
    @Enumerated( EnumType.STRING )
    @NonNull
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
