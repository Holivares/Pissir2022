package edu.uniupo.coltivazioni.entity;

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
@Table( name = "AGRICULTURAL_HOLDING", uniqueConstraints = @UniqueConstraint( columnNames = "NAME" ) )
public class AziendaAgricolaEntity implements Serializable {

    @Id
    @Column( name = "ID_AGRICULTURAL_HOLDING" )
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID idAziendaAgricola;
    @NotNull
    @NonNull
    @JoinColumn( name = "ID_USER" )
    @OneToOne( orphanRemoval = true )
    private UtenteEntity utenteEntity;
    @NotNull
    @NonNull
    @NotBlank
    @Column( name = "NAME", length = 25 )
    private String nome;
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
        AziendaAgricolaEntity that = ( AziendaAgricolaEntity ) o;
        return getIdAziendaAgricola() != null && Objects.equals( getIdAziendaAgricola(), that.getIdAziendaAgricola() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
