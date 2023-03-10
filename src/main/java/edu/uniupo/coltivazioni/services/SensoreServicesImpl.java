package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Sensore;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOSensore;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.SensoreRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
@Service
public class SensoreServicesImpl implements SensoreServices {

    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    SensoreRepositori sensoreRepositori;

    @Autowired
    public SensoreServicesImpl ( SensoreRepositori sensoreRepositori ) {
        this.sensoreRepositori = sensoreRepositori;
    }

    @Override
    public DTOSensore getSensore ( Long idSensore ) {
        final Sensore nullSensore = new Sensore();
        final Sensore sensore = sensoreRepositori.findById( idSensore ).orElse( nullSensore );

        return mapper.sensoreToDTOSensore( sensore );
    }

    @Override
    public DTOSensore saveSensore ( DTOSensore dtoSensore ) {
        Sensore sensore = sensoreRepositori.save( mapper.dTOSensoreToSensore( dtoSensore, new Sensore() ) );
        return mapper.sensoreToDTOSensore( sensore );
    }

    @Override
    public DTOSensore updateSensore ( DTOSensore dtoSensore ) {
        Sensore oldSensore = sensoreRepositori.findById( dtoSensore.getIdSensore() ).orElse( new Sensore() );
        Sensore sensore = sensoreRepositori.save( mapper.dTOSensoreToSensore( dtoSensore, oldSensore ) );
        return mapper.sensoreToDTOSensore( sensore );
    }

    @Override
    public DTODeletedResponse deleteSensore ( Long idSensore ) {
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse( true, "Sensore Deleted" );
        sensoreRepositori.findById( idSensore ).ifPresentOrElse( sensoreRepositori::delete, () -> {
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        } );
        return dtoDeletedResponse;
    }
}
