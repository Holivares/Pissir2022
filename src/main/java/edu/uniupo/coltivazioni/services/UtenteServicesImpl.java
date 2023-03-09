package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Utente;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOUtente;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.UtenteRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        return mapper.toDtoUtente( utente );
    }

    @Override
    public DTOUtente saveUtente ( DTOUtente dtoUtente ) {
        Utente NewUtente = new Utente();
        mapper.toUtente(dtoUtente,NewUtente);
        Utente utente = utenteRepositori.save( NewUtente);
        return mapper.toDtoUtente( utente );
    }

    @Override
    public DTOUtente updateUtente(DTOUtente dtoUtente) {
        Utente oldUtente = utenteRepositori.findById(dtoUtente.getIdUtente()).orElse(new Utente());
        mapper.toUtente(dtoUtente,oldUtente);
        Utente utente = utenteRepositori.save(oldUtente);
        return mapper.toDtoUtente(utente);
    }

    @Override
    public DTODeletedResponse deleteUtente(Long idUtente) {
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse(true, "Utente Deleted");
        Optional<Utente> deleteCondidateUtente = utenteRepositori.findById(idUtente);
        deleteCondidateUtente.ifPresentOrElse(deleteCondidate -> {
            System.out.println("deletedCondidate found = " + deleteCondidate.getIdUtente() + " " + deleteCondidate.getNome());
            utenteRepositori.delete(deleteCondidate);
        }, () ->{
            System.out.println( "deleteCondidate not found ");
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        });
        return dtoDeletedResponse;
    }
}
