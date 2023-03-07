package edu.uniupo.coltivazioni.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "SENSORE")
/*creano in automatico costruttore, getters, setters*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sensore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSensore;
    @Column(name = "DESCRIZIONE")
    private String descrizione;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "DATE_TIME")
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn( name = "SERRA_ID" )
    private Serra serra;

}
