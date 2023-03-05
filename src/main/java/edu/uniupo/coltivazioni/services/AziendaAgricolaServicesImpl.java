package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.AziendaAgricola;

import edu.uniupo.coltivazioni.dto.DTOAziendaAgricola;

import edu.uniupo.coltivazioni.mapper.DTOToDAO;
import edu.uniupo.coltivazioni.repositori.AziendaAgricolaRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
//Disce cosa farà il metodo
//Une seule implementation pour une classe
@Service
public class AziendaAgricolaServicesImpl implements AziendaAgricolaServices {
    //Recupère toutes les methodes des classes et les mettre dans l'objet mapper
    private DTOToDAO mapper = Mappers.getMapper(DTOToDAO.class);

    private AziendaAgricolaRepositori aziendaAgricolaRepositori;
    //injection de dependances della DB
    //va rechercher dans mon code la classe qui implemente cette interface, vu que l'on ne peut pas créer une instance d'une interface...
    @Autowired
    public AziendaAgricolaServicesImpl(AziendaAgricolaRepositori aziendaAgricolaRepositori) {
        this.aziendaAgricolaRepositori = aziendaAgricolaRepositori;
    }

    @Override
    public DTOAziendaAgricola getAziendaAgricola(Long idAziendaAgricola) {
       final AziendaAgricola nullAziendaAgricola = new AziendaAgricola();
       final AziendaAgricola aziendaAgricola = aziendaAgricolaRepositori.findById(idAziendaAgricola).orElse(nullAziendaAgricola);

       return mapper.toDtoAziendaAgricola(aziendaAgricola);
    }

    @Override
    public DTOAziendaAgricola saveAzienda(DTOAziendaAgricola dtoAziendaAgricola) {
         AziendaAgricola aziendaAgricola = aziendaAgricolaRepositori.save(mapper.toAziendaAgricola(dtoAziendaAgricola));
         return mapper.toDtoAziendaAgricola(aziendaAgricola);

    }


}
