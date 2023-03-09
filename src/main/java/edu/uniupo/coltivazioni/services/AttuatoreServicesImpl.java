package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Attuatore;
import edu.uniupo.coltivazioni.dao.ProgrammaIrrig;
import edu.uniupo.coltivazioni.dto.DTOAttuatore;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.AttuatoreRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author
 * @author
 */
@Service
public class AttuatoreServicesImpl implements AttuatoreServices {
    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    AttuatoreRepositori attuatoreRepositori;

    @Autowired
    public AttuatoreServicesImpl ( AttuatoreRepositori attuatoreRepositori ) {
        this.attuatoreRepositori = attuatoreRepositori;
    }

    @Override
    public DTOAttuatore getAttuatore ( Long idAttuatore ) {
        final Attuatore nullAttuatore = new Attuatore();
        final Attuatore attuatore = attuatoreRepositori.findById( idAttuatore ).orElse( nullAttuatore );

        return mapper.toDtoAttuatore( attuatore );
    }

    @Override
    public DTOAttuatore saveAttuatore ( DTOAttuatore dtoAttuatore ) {
        Attuatore NewAttuatore = new Attuatore();
        mapper.toAttuatore(dtoAttuatore, NewAttuatore);
        Attuatore attuatore = attuatoreRepositori.save( NewAttuatore);
        return mapper.toDtoAttuatore( attuatore );
    }

    @Override
    public DTOAttuatore updateProgramma(DTOAttuatore dtoAttuatore) {
        Attuatore oldAttuatore = attuatoreRepositori.findById(dtoAttuatore.getIdAttuatore()).orElse(new Attuatore());
        mapper.toAttuatore(dtoAttuatore, oldAttuatore);
        Attuatore attuatore = attuatoreRepositori.save(oldAttuatore);
        return mapper.toDtoAttuatore(attuatore);
    }
    @Override
    public DTODeletedResponse deleteAttuatore(Long idAttuatore) {
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse(true,"Programma Deleted");
        Optional<Attuatore> deleteCondidateAttuatore = attuatoreRepositori.findById(idAttuatore);
        deleteCondidateAttuatore.ifPresentOrElse(deleteCondidate -> {
            System.out.println("deleteCondidate found = " + deleteCondidate.getIdAttuatore() + " " + deleteCondidate.getDescrizione());
            attuatoreRepositori.delete(deleteCondidate);
        }, () -> {
            System.out.println( "deleteCondidate not found ");
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        });
        return dtoDeletedResponse;
    }


}
