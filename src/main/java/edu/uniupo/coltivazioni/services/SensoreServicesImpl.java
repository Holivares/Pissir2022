package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOSensore;
import edu.uniupo.coltivazioni.entities.Sensore;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.SensoreRepositori;
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
public class SensoreServicesImpl implements  SensoreServices{

   private final SensoreRepositori  sensoreRepositori;
   private final ObjectMapper mapper = Mappers.getMapper(ObjectMapper.class);

    public SensoreServicesImpl(SensoreRepositori sensoreRepositori) {
        this.sensoreRepositori = sensoreRepositori;
    }

    @Override
    public DTOSensore createSensore(DTOSensore dtoSensore) {
        Sensore sensore = sensoreRepositori.save(mapper.dTOSensoreTOSensore(dtoSensore));
        return mapper.sensoreTODTOSensore(sensore);
    }

    @Override
    public DTOSensore findSensoreByIdSerra(UUID idSerra) {
        Optional<Sensore> sensore = sensoreRepositori.findBySerraIdSerra(idSerra);
        return mapper.sensoreTODTOSensore(sensore.orElse(new Sensore()));
    }
}
