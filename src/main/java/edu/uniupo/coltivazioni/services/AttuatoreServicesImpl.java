package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOAttuatore;
import edu.uniupo.coltivazioni.entities.Attuatore;
import edu.uniupo.coltivazioni.entities.AttuatoreStato;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.AttuatoreRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author
 * @author
 */
@Service
public class AttuatoreServicesImpl implements AttuatoreServices{

   private  AttuatoreRepositori attuatoreRepositori;
   private final ObjectMapper objectMapper = Mappers.getMapper(ObjectMapper.class);
    @Autowired
    public AttuatoreServicesImpl(AttuatoreRepositori attuatoreRepositori) {
        this.attuatoreRepositori = attuatoreRepositori;
    }


    @Override
    public DTOAttuatore findAttuatoreByIdSerra(UUID idSerra) {
       Optional<Attuatore> attuatore = attuatoreRepositori.findAttuatoreBySerraIdSerra(idSerra);
        return objectMapper.attuatoreToDTOAttuatore(attuatore.orElse(new Attuatore()));
    }

    @Override
    public DTOAttuatore enableAttuatore(UUID idAttuatore) {
        Optional<Attuatore> attuatore = attuatoreRepositori.findById(idAttuatore);
        attuatore.ifPresent(attuatore1 -> attuatore1.getStato().setStato(AttuatoreStato.ATTIVO));
        return objectMapper.attuatoreToDTOAttuatore(attuatore.orElse(new Attuatore()));
    }

    @Override
    public DTOAttuatore disableAttuatore(UUID idAttuatore) {
        Optional<Attuatore> attuatore = attuatoreRepositori.findById(idAttuatore);
        attuatore.ifPresent(attuatore1 -> attuatore1.getStato().setStato(AttuatoreStato.DISATTIVATO));
        return objectMapper.attuatoreToDTOAttuatore(attuatore.orElse(new Attuatore()));
    }

}
