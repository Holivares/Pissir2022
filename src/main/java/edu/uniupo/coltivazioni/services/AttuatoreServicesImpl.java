package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Attuatore;
import edu.uniupo.coltivazioni.dto.DTOAttuatore;
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

        return mapper.toDtoAttuatore( attuatore );
    }

    @Override
    public DTOAttuatore saveAttuatore ( DTOAttuatore dtoAttuatore ) {
        Attuatore attuatore = attuatoreRepositori.save( mapper.toAttuatore( dtoAttuatore ) );
        return mapper.toDtoAttuatore( attuatore );
    }
}
