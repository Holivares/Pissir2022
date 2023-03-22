package edu.uniupo.coltivazioni.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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
@Table( name = "AGRICULTURAL_HOLDING" )
public class AziendaAgricola implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_AGRICULTURAL_HOLDING", length = 10 )
    private UUID idAziendaAgricola;
    @OneToOne( orphanRemoval = true )
    @JoinColumn( name = "ID_USER" )
    @NonNull
    @Valid
    private Utente utente;
    @Column( name = "NAME", length = 25 )
    @NonNull
    @NotBlank
    private String nome;
    @Column( name = "DESCRIPTION", length = 100 )
    @NonNull
    @NotBlank
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
