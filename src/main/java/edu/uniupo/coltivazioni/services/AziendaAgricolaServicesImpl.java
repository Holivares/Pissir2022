package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.AziendaAgricola;
import edu.uniupo.coltivazioni.repositori.AziendaAgricolaRepositori;
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

    AziendaAgricolaRepositori aziendaAgricolaRepositori;
    //injection de dependances della DB
    //va rechercher dans mon code la classe qui implemente cette interface, vu que l'on ne peut pas créer une instance d'une interface...
    @Autowired
    public AziendaAgricolaServicesImpl(AziendaAgricolaRepositori aziendaAgricolaRepositori) {
        this.aziendaAgricolaRepositori = aziendaAgricolaRepositori;
    }

    @Override
    public AziendaAgricola getAziendaAgricola(Long id) {
       final AziendaAgricola aziendaAgricola = new AziendaAgricola();

   //optional supprime les Nullpointer exception
   //orElse: si optional de AziendeAgricola contient une val diff de null return cette valeur
    //findById retourne un optional contenant une valeur de type aziendaAgricola
       return aziendaAgricolaRepositori.findById(id).orElse(aziendaAgricola);
    }

    @Override
    public AziendaAgricola createAzienda(AziendaAgricola aziendaAgricola) {
        return aziendaAgricolaRepositori.save(aziendaAgricola);

    }


}
