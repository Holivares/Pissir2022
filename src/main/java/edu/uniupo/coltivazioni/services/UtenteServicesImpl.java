package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Utente;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
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
public class UtenteServicesImpl implements UtenteServices {
    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    UtenteRepositori utenteRepositori;

    public UtenteServicesImpl ( UtenteRepositori utenteRepositori ) {
        this.utenteRepositori = utenteRepositori;
    }

    @Override
    public DTOUtente getUtente ( Long idUtente ) {
        final Utente nullUtente = new Utente();
        final Utente utente = utenteRepositori.findById( idUtente ).orElse( nullUtente );

        return mapper.utenteToDTOUtente( utente );
    }

    @Override
    public DTOUtente saveUtente ( DTOUtente dtoUtente ) {
        Utente utente = utenteRepositori.save( mapper.dTOUtenteToUtente( dtoUtente, new Utente() ) );
        return mapper.utenteToDTOUtente( utente );
    }

    @Override
    public DTOUtente updateUtente ( DTOUtente dtoUtente ) {
        Utente oldUtente = utenteRepositori.findById( dtoUtente.getIdUtente() ).orElse( new Utente() );
        Utente utente = utenteRepositori.save( mapper.dTOUtenteToUtente( dtoUtente, oldUtente ) );
        return mapper.utenteToDTOUtente( utente );
    }

    @Override
    public DTODeletedResponse deleteUtente ( Long idUtente ) {
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse( true, "Utente Deleted" );
        utenteRepositori.findById( idUtente ).ifPresentOrElse( utenteRepositori::delete, () -> {
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        } );
        return dtoDeletedResponse;
    }
}
