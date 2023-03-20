package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOMisura;
import edu.uniupo.coltivazioni.entities.Misura;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.MisuraRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MisuraServicesImpl implements MisuraServices{

    private final MisuraRepositori misuraRepositori;

    private ObjectMapper mapper = Mappers.getMapper(ObjectMapper.class);

    @Autowired
    public MisuraServicesImpl(MisuraRepositori misuraRepositori) {
        this.misuraRepositori = misuraRepositori;

    }

    @Override
    public DTOMisura createMisura(DTOMisura dtoMisura) {
        Misura misura = misuraRepositori.save(mapper.dTOMisuraTOMisura(dtoMisura));
        return mapper.misuraTODTOMisura(misura);
    }

    @Override
    public DTOMisura findMisuraById(UUID idMisura) {
        Optional<Misura> misura =  misuraRepositori.findById(idMisura);
        return mapper.misuraTODTOMisura(misura.orElse(new Misura()));
    }

    @Override
    public DTOMisura findMisuraBySensoreId(UUID idSensore) {
        Optional<Misura> misura = misuraRepositori.findBySensoreIdSensore(idSensore);
        return mapper.misuraTODTOMisura(misura.orElse(new Misura()));
    }
}
