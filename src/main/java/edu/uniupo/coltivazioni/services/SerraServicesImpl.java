package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOSerra;
import edu.uniupo.coltivazioni.entities.Serra;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.SerraRepositori;
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
public class SerraServicesImpl implements SerraServices {

    private final SerraRepositori serraRepositori;
    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    public SerraServicesImpl ( SerraRepositori serraRepositori ) {
        this.serraRepositori = serraRepositori;
    }

    @Override
    public DTOSerra createSerra ( DTOSerra dtoSerra ) {
        Serra serra = serraRepositori.save( mapper.dTOSerraToSerra( dtoSerra ) );
        return mapper.serraToDTOSerra( serra );
    }

    @Override
    public DTOSerra updateSerra ( DTOSerra dtoSerra ) {
        Serra serra = serraRepositori.save( mapper.dTOSerraToSerra( dtoSerra ) );
        return mapper.serraToDTOSerra( serra );
    }

    @Override
    public DTODeleteResponse deleteSerra ( UUID idSerra ) {
        serraRepositori.deleteById( idSerra );
        return new DTODeleteResponse( "Serra is deleted", true );
    }

    @Override
    public DTOSerra findSerraByIdAziendaAgricola ( UUID idAziendaAgricola ) {
        Optional<Serra> serra = serraRepositori.findByAziendaAgricolaIdAziendaAgricola( idAziendaAgricola );
        return mapper.serraToDTOSerra( serra.orElse( new Serra() ) );
    }
}
