package edu.uniupo.coltivazioni.dao;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;

import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Entity
@Table( name = "SERRA" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Serra implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long idSerra;
    @OneToMany( mappedBy = "serra", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Attuatore> attuatore;
    @OneToMany( mappedBy = "serra", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Misura> misura;
    @OneToMany( mappedBy = "serra", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Sensore> sensore;
    @Column( name = "DESCRIZIONE" )
    private String descrizione;
    @Column( name = "TIPO_COLTURA" )
    private String tipoColtura;
    @ManyToOne
    @JoinColumn( name = "ID_AZIENDA_AGRICOLA" )
    @Cascade( SAVE_UPDATE )
    private AziendaAgricola aziendaAgricola;

}

