package edu.uniupo.coltivazioni.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SerraModel {
    private UUID idSerra;
    private UUID idAziendaAgricola;
    private String descrizione;
}
