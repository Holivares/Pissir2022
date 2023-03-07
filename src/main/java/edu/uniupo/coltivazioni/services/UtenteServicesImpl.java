package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Utente;
import edu.uniupo.coltivazioni.dto.DTOUtente;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.UtenteRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
@Service
public class UtenteServicesImpl implements UtenteServices{
    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    UtenteRepositori utenteRepositori;
    public UtenteServicesImpl(UtenteRepositori utenteRepositori){
        this.utenteRepositori = utenteRepositori;
    }
    @Override
    public DTOUtente getUtente(Long idUtente) {
        final Utente nullUtente = new Utente();
        final Utente utente = utenteRepositori.findById(idUtente).orElse(nullUtente);

        return mapper.toDtoUtente(utente);
    }

    @Override
    public DTOUtente saveUtente(DTOUtente dtoUtente) {
        Utente utente = utenteRepositori.save(mapper.toUtente(dtoUtente));
        return mapper.toDtoUtente(utente);
    }
}
