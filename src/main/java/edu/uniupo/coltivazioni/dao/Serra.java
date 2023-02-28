package edu.uniupo.coltivazioni.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "SERRA")
/*creano in automatico costruttore, getters, setters*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Serra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Attuatore> attuatore;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Misura> misura;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Sensore> sensore;
    @Column(name = "DESCRIZIONE")
    private String descrizione;
    @Column(name = "TIPO_COLTURA")
    private String tipoColtura;

    /*Créer methode planification et configurer les accès pour les actions des collaborateurs */
}

