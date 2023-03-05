package edu.uniupo.coltivazioni.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "MISURA")
/*creano in automatico costruttore, getters, setters*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Misura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMisura;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "MISURAZIONI")
    private String misurazioni;
    @Column(name = "DATE_TIME")
    private Date dateTime;
    @ManyToOne
    @JoinColumn( name = "SERRA_ID" )
    private Serra serra;

}