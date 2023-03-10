package edu.uniupo.coltivazioni.dao;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table( name = "AZIENDA_AGRI" )
/*creano in automatico costruttore, getters, setters*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AziendaAgricola implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long idAziendaAgricola;
    @Column( name = "DESCRIZIONE" )
    private String descrizione;
    @Column( name = "TIPO" )
    private String tipo;
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "aziendaAgricola", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Serra> serraList;
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "aziendaAgricola", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Utente> utenteList;

}
