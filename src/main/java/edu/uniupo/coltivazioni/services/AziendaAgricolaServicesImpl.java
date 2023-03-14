package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOAziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.entities.AziendaAgricola;
import edu.uniupo.coltivazioni.repositori.AziendaAgricolaRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author
 * @author
 */
@Service
public class AziendaAgricolaServicesImpl implements AziendaAgricolaServices{
    private AziendaAgricolaRepositori aziendaAgricolaRepositori;
    @Autowired
    public AziendaAgricolaServicesImpl(AziendaAgricolaRepositori aziendaAgricolaRepositori){
        this.aziendaAgricolaRepositori = aziendaAgricolaRepositori;
    }

    @Override
    public DTOAziendaAgricola createAziendaAgricola(DTOAziendaAgricola aziendaAgricola) {
        return null;
    }

    @Override
    public DTOAziendaAgricola updateAziendaAgricola(DTOAziendaAgricola dtoAziendaAgricola) {
        return null;
    }

    @Override
    public DTODeleteResponse deleteAziendaAgricola(UUID idAziendaAgricola) {
        return null;
    }


    @Override
    public DTOAziendaAgricola findAziendaAgricolaByIdUser(UUID idUtente) {
        return null;
    }

    @Override
    public DTOAziendaAgricola findAziendaAgricolaById(UUID idAziendaAgricola) {
        return null;
    }

    @Override
    public DTOAziendaAgricola findAziendaAgricolaByName(String nome) {
        return null;
    }
}
