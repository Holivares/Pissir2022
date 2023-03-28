package edu.uniupo.coltivazioni.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table( name = "PERSON", uniqueConstraints = @UniqueConstraint( columnNames = { "EMAIL" } ) )
public class UtenteEntity implements Serializable {

    @Id
    @Column( name = "ID_USER" )
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID idUtente;
    @NotNull
    @NonNull
    @NotBlank
    @Column( name = "NAME", length = 25 )
    private String nome;
    @NotNull
    @NonNull
    @NotBlank
    @Column( name = "FIRST_NAME", length = 40 )
    private String cognome;
    @Email
    @NotNull
    @NonNull
    @NotBlank
    @Column( name = "EMAIL", length = 50 )
    private String email;
    @NotNull
    @NonNull
    @NotBlank
    @Column( name = "PASSWORD", length = 55 )
    private String password;
    @NotNull
    @NonNull
    @Column( name = "ROLE" )
    @Enumerated( EnumType.STRING )
    private RuoloEntity role;

    @Override
    public boolean equals ( Object o ) {
        if( this == o ) {
            return true;
        }
        if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) {
            return false;
        }
        UtenteEntity utenteEntity = ( UtenteEntity ) o;
        return getIdUtente() != null && Objects.equals( getIdUtente(), utenteEntity.getIdUtente() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}