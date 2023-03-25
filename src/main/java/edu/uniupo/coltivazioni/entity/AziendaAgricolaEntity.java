package edu.uniupo.coltivazioni.entity;

import jakarta.persistence.*;
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
public class AziendaAgricolaEntity implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_AGRICULTURAL_HOLDING" )
    private UUID idAziendaAgricola;
    @OneToOne( orphanRemoval = true )
    @JoinColumn( name = "ID_USER" )
    @NonNull
    private UtenteEntity utenteEntity;
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
        AziendaAgricolaEntity that = ( AziendaAgricolaEntity ) o;
        return getIdAziendaAgricola() != null && Objects.equals( getIdAziendaAgricola(), that.getIdAziendaAgricola() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
