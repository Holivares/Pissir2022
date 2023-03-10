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
@Table( name = "UTENTE" )
/*creano in automatico costruttore, getters, setters*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Utente implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long idUtente;
    @Column( name = "USERNAME" )
    private String username;
    @Column( name = "EMAIL" )
    private String email;
    @Column( name = "NOME" )
    private String nome;
    @Column( name = "COGNOME" )
    private String cognome;
    @Column( name = "RUOLO" )
    private String ruolo;
    @ManyToOne
    @JoinColumn( name = "ID_AZIENDA_AGRICOLA" )
    @Cascade( SAVE_UPDATE )
    private AziendaAgricola aziendaAgricola;

}
