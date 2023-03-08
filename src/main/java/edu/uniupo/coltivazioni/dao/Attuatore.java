package edu.uniupo.coltivazioni.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;

import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Entity
@Table( name = "ATTUATORE" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Attuatore implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long idAttuatore;
    @Column( name = "DESCRIZIONE" )
    private String descrizione;
    @Column( name = "STATO" )
    private String stato;
    @Column( name = "IS_MANUAL" )
    private boolean isManual;
    @ManyToOne
    @JoinColumn( name = "SERRA_ID" )
    @Cascade( SAVE_UPDATE )
    private Serra serra;

}
