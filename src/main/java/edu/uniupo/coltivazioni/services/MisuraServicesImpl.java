package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Misura;
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
    public MisuraServicesImpl(MisuraRepositori misuraRepositori){
        this.misuraRepositori = misuraRepositori;
    }

    @Override
    public DTOMisura getMisura(Long idMisura) {
        final Misura nullMisura = new Misura();
        final Misura misura = misuraRepositori.findById(idMisura).orElse(nullMisura);

        return mapper.toDtoMisura(misura);
    }

    @Override
    public DTOMisura saveMisura(DTOMisura dtoMisura) {
        Misura misura = misuraRepositori.save(mapper.toMisura(dtoMisura));
        return mapper.toDtoMisura(misura);
    }
}
