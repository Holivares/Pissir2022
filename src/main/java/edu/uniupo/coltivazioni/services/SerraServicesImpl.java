package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Serra;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOSerra;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.SerraRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
@Service
public class SerraServicesImpl implements SerraServices {
    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    SerraRepositori serraRepositori;

    @Autowired
    public SerraServicesImpl ( SerraRepositori serraRepositori ) {
        this.serraRepositori = serraRepositori;
    }

    @Override
    public DTOSerra getSerra ( Long idSerra ) {
        final Serra nullSerra = new Serra();
        final Serra serra = serraRepositori.findById( idSerra ).orElse( nullSerra );
        return mapper.serraToDTOSerra( serra );
    }

    @Override
    public DTOSerra saveSerra ( DTOSerra dtoSerra ) {
        Serra NewSerra = new Serra();
        mapper.dTOSerraToSerra( dtoSerra, NewSerra );
        Serra serra = serraRepositori.save( NewSerra );
        return mapper.serraToDTOSerra( serra );
    }

    @Override
    public DTOSerra updateSerra ( DTOSerra dtoSerra ) {
        Serra oldSerra = serraRepositori.findById( dtoSerra.getIdSerra() ).orElse( new Serra() );
        Serra serra = serraRepositori.save( mapper.dTOSerraToSerra( dtoSerra, oldSerra ) );
        return mapper.serraToDTOSerra( serra );
    }

    @Override
    public DTODeletedResponse deleteSerra ( Long idSerra ) {
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse( true, "Serra Deleted" );
        serraRepositori.findById( idSerra ).ifPresentOrElse( serraRepositori::delete, () -> {
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        } );
        return dtoDeletedResponse;
    }
}
