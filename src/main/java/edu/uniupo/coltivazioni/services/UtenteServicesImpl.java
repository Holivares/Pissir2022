package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOUtente;
import edu.uniupo.coltivazioni.entities.Utente;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.UtenteRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * @author
 * @author
 */
@Service
@Transactional
public class UtenteServicesImpl implements UtenteServices {

    private final UtenteRepositori utenteRepositori;
    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    public UtenteServicesImpl ( UtenteRepositori utenteRepositori ) {
        this.utenteRepositori = utenteRepositori;
    }

    @Override
    public DTOUtente createUtente ( DTOUtente dtoUtente ) {
        Utente utente = utenteRepositori.save( mapper.dTOUtenteTOUtente( dtoUtente ) );
        return mapper.utenteTODTOUtente( utente );
    }

    @Override
    public DTOUtente updateUtente ( DTOUtente dtoUtente ) {
        Utente utente = utenteRepositori.save( mapper.dTOUtenteTOUtente( dtoUtente ) );
        return mapper.utenteTODTOUtente( utente );
    }

    @Override
    public DTODeleteResponse deleteUtenteById ( UUID idUtente ) {
        utenteRepositori.deleteById( idUtente );
        return new DTODeleteResponse( "Utente is deleted", true );
    }

    @Override
    public DTOUtente findUtenteByEmailAndPassword ( String email, String password ) {
        Optional<Utente> utente = utenteRepositori.findByEmail( email );
        return mapper.utenteTODTOUtente( utente.orElse( new Utente() ) );
    }
}
