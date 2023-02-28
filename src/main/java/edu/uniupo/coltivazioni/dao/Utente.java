package edu.uniupo.coltivazioni.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "UTENTE")
/*creano in automatico costruttore, getters, setters*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Utente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name= "USERNAME")
    private String username;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "COGNOME")
    private String cognome;
    @Column(name = "RUOLO")
    private String ruolo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "AZIENDA_AGRICOLA_ID")
    private AziendaAgricola aziendaAgricola;

}
