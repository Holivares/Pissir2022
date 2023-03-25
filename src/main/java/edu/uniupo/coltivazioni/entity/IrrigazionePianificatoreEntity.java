package edu.uniupo.coltivazioni.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "IRRIGATION_SCHEDULER" )
public class IrrigazionePianificatoreEntity implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "ID_IRRIGATION_SCHEDULER" )
    private UUID idIrrigazionePianificatore;
    @ManyToOne
    @JoinColumn( name = "ID_AGRICULTURAL_HOLDING" )
    private AziendaAgricolaEntity aziendaAgricolaEntity;
    @ManyToOne
    @JoinColumn( name = "ID_GREENHOUSE" )
    private SerraEntity serraEntity;
    @Column( name = "DESCRIPTION", length = 100 )
    private String descrizione;
    @Column( name = "EXECUTION_DATE" )
    private LocalDate esecuzioneData;
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
