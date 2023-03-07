package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Sensore;
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
public class SensoreServicesImpl implements SensoreServices{

    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    SensoreRepositori sensoreRepositori;
    @Autowired
    public SensoreServicesImpl(SensoreRepositori sensoreRepositori){
        this.sensoreRepositori = sensoreRepositori;
    }

    @Override
    public DTOSensore getSensore(Long idSensore) {
        final Sensore nullSensore = new Sensore();
        final Sensore sensore = sensoreRepositori.findById(idSensore).orElse(nullSensore);

        return mapper.toDtoSensore(sensore);
    }

    @Override
    public DTOSensore saveSensore(DTOSensore dtoSensore) {
        Sensore sensore = sensoreRepositori.save(mapper.toSensore(dtoSensore));
        return mapper.toDtoSensore(sensore);
    }
}
