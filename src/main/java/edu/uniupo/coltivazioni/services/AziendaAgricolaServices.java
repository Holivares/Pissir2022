package edu.uniupo.coltivazioni.services;


import edu.uniupo.coltivazioni.dao.AziendaAgricola;

/**
 * @author Evrard Holivares
 * @author
 */
//Implementazione della logica che spetta il cliente (es Stato: 200, Body: lista serre
//Listo i miei metodi
public interface AziendaAgricolaServices {
    AziendaAgricola getAziendaAgricola(Long id);
    AziendaAgricola createAzienda(AziendaAgricola aziendaAgricola);
}

