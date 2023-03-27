package edu.uniupo.coltivazioni.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table( name = "IRRIGATION_SCHEDULER" )
public class IrrigazionePianificatoreEntity implements Serializable {

    @Id
    @Column( name = "ID_IRRIGATION_SCHEDULER" )
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID idIrrigazionePianificatore;
    @NotNull
    @ManyToOne
    @JoinColumn( name = "ID_AGRICULTURAL_HOLDING" )
    private AziendaAgricolaEntity aziendaAgricolaEntity;
    @NotNull
    @ManyToOne
    @JoinColumn( name = "ID_GREENHOUSE" )
    private SerraEntity serraEntity;
    @NotNull
    @NotBlank
    @Column( name = "DESCRIPTION", length = 100 )
    private String descrizione;
    @NotNull
    @Column( name = "EXECUTION_DATE" )
    private LocalDate esecuzioneData;
    @NotNull
    @Embedded
    private ExecutionTimeEntity esecuzioneTempo;

    @Override
    public boolean equals ( Object o ) {
        if( this == o ) {
            return true;
        }
        if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) {
            return false;
        }
        IrrigazionePianificatoreEntity that = ( IrrigazionePianificatoreEntity ) o;
        return getIdIrrigazionePianificatore() != null && Objects.equals( getIdIrrigazionePianificatore(), that.getIdIrrigazionePianificatore() );
    }

    @Override
    public int hashCode () {
        return getClass().hashCode();
    }
}
