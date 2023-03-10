package edu.uniupo.coltivazioni.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.time.LocalDateTime;

import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Entity
@Table( name = "SENSORE" )
/*creano in automatico costruttore, getters, setters*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sensore implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long idSensore;
    @Column( name = "DESCRIZIONE" )
    private String descrizione;
    @Column( name = "TIPO" )
    private String tipo;
    @Column( name = "DATE_TIME" )
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn( name = "SERRA_ID" )
    @Cascade( SAVE_UPDATE )
    private Serra serra;

}
