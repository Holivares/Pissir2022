package edu.uniupo.coltivazioni.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "AZIENDA_AGRI")
/*creano in automatico costruttore, getters, setters*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AziendaAgricola implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "DESCRIZIONE")
    private String descrizione;
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Serra> serraList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Utente> utenteList;


}
