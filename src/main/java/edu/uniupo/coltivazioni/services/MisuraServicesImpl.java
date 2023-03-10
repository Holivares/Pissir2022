package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Misura;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOMisura;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.MisuraRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
@Service
public class MisuraServicesImpl implements MisuraServices {
    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    MisuraRepositori misuraRepositori;

    @Autowired
    public MisuraServicesImpl ( MisuraRepositori misuraRepositori ) {
        this.misuraRepositori = misuraRepositori;
    }

    @Override
    public DTOMisura getMisura ( Long idMisura ) {
        final Misura nullMisura = new Misura();
        final Misura misura = misuraRepositori.findById( idMisura ).orElse( nullMisura );

        return mapper.misuraToDTOMisura( misura );
    }

    @Override
    public DTOMisura saveMisura ( DTOMisura dtoMisura ) {
        Misura misura = misuraRepositori.save( mapper.dTOMisuraToMisura( dtoMisura, new Misura() ) );
        return mapper.misuraToDTOMisura( misura );
    }

    @Override
    public DTOMisura updateMisura ( DTOMisura dtoMisura ) {
        Misura oldMisura = misuraRepositori.findById( dtoMisura.getIdMisura() ).orElse( new Misura() );
        Misura misura = misuraRepositori.save( mapper.dTOMisuraToMisura( dtoMisura, oldMisura ) );
        return mapper.misuraToDTOMisura( misura );
    }

    @Override
    public DTODeletedResponse deleteMisura ( Long idMisura ) {
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse( true, "Misura Deleted" );
        misuraRepositori.findById( idMisura ).ifPresentOrElse( misuraRepositori::delete, () -> {
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        } );
        return dtoDeletedResponse;
    }
}
