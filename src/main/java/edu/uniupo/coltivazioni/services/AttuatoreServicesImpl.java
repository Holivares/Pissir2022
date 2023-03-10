package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Attuatore;
import edu.uniupo.coltivazioni.dto.DTOAttuatore;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.AttuatoreRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return mapper.attuatoreToDTOAttuatore( attuatore );
    }

    @Override
    public DTOAttuatore saveAttuatore ( DTOAttuatore dtoAttuatore ) {
        Attuatore attuatore = attuatoreRepositori.save( mapper.dTOAttuatoreToAttuatore( dtoAttuatore, new Attuatore() ) );
        return mapper.attuatoreToDTOAttuatore( attuatore );
    }

    @Override
    public DTOAttuatore updateAttuatore ( DTOAttuatore dtoAttuatore ) {
        Attuatore oldAttuatore = attuatoreRepositori.findById( dtoAttuatore.getIdAttuatore() ).orElse( new Attuatore() );
        Attuatore attuatore = attuatoreRepositori.save( mapper.dTOAttuatoreToAttuatore( dtoAttuatore, oldAttuatore ) );
        return mapper.attuatoreToDTOAttuatore( attuatore );
    }

    @Override
    public DTODeletedResponse deleteAttuatore ( Long idAttuatore ) {
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse( true, "Attuatore Deleted" );
        attuatoreRepositori.findById( idAttuatore ).ifPresentOrElse( attuatoreRepositori::delete, () -> {
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        } );
        return dtoDeletedResponse;
    }
}
