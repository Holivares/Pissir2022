package edu.uniupo.coltivazioni.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table( name = "PROGRAMMA_IRRIG" )
/*creano in automatico costruttore, getters, setters*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgrammaIrrig implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long idProgramma;
    @Column( name = "DATE" )
    private LocalDateTime dateTime;
    @Column( name = "ORA_INIZIO" )
    private int oraInizio;
    @Column( name = "ORA_FINE" )
    private int oraFine;
    @Column( name = "DESCRIZIONE" )
    private String descrizione;
    @Column( name = "TIPO" )
    private TipoProgramma tipo;

}
