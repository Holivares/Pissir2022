package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.AziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTOAziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.AziendaAgricolaRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */

@Service
public class AziendaAgricolaServicesImpl implements AziendaAgricolaServices {

    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    private final AziendaAgricolaRepositori aziendaAgricolaRepositori;

    @Autowired
    public AziendaAgricolaServicesImpl ( AziendaAgricolaRepositori aziendaAgricolaRepositori ) {
        this.aziendaAgricolaRepositori = aziendaAgricolaRepositori;
    }

    @Override
    public DTOAziendaAgricola getAziendaAgricola ( Long idAziendaAgricola ) {
        final AziendaAgricola aziendaAgricola = aziendaAgricolaRepositori.findById( idAziendaAgricola ).orElse( new AziendaAgricola() );
        return mapper.aziendaAgricolaToDTOAziendaAgricola( aziendaAgricola );
    }

    @Override
    public DTOAziendaAgricola saveAzienda ( DTOAziendaAgricola dtoAziendaAgricola ) {
        mapper.dTOAziendaAgricolaToAziendaAgricola( dtoAziendaAgricola, new AziendaAgricola() );
        AziendaAgricola aziendaAgricola = aziendaAgricolaRepositori.save( mapper.dTOAziendaAgricolaToAziendaAgricola( dtoAziendaAgricola, new AziendaAgricola() ) );
        return mapper.aziendaAgricolaToDTOAziendaAgricola( aziendaAgricola );

    }

    @Override
    public DTOAziendaAgricola updateAzienda ( DTOAziendaAgricola dtoAziendaAgricola ) {
        AziendaAgricola oldAziendaAgricola = aziendaAgricolaRepositori.findById( dtoAziendaAgricola.getIdAziendaAgricola() ).orElse( new AziendaAgricola() );
        AziendaAgricola aziendaAgricola = aziendaAgricolaRepositori.save( mapper.dTOAziendaAgricolaToAziendaAgricola( dtoAziendaAgricola, oldAziendaAgricola ) );
        return mapper.aziendaAgricolaToDTOAziendaAgricola( aziendaAgricola );
    }

    @Override
    public DTODeletedResponse deleteAzienda ( Long idAziendaAgricola ) {
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse( true, "Azienda Agricola Deleted" );
        aziendaAgricolaRepositori.findById( idAziendaAgricola ).ifPresentOrElse( aziendaAgricolaRepositori::delete, () -> {
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        } );
        return dtoDeletedResponse;
    }

}
