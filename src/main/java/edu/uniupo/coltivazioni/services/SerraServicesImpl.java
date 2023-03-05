package edu.uniupo.coltivazioni.services;
import edu.uniupo.coltivazioni.dao.Serra;
import edu.uniupo.coltivazioni.dto.DTOSerra;
import edu.uniupo.coltivazioni.mapper.DTOToDAO;
import edu.uniupo.coltivazioni.repositori.SerraRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
@Service
public class SerraServicesImpl implements SerraServices{
    private DTOToDAO mapper = Mappers.getMapper(DTOToDAO.class);

    SerraRepositori serraRepositori;
    @Autowired
    public SerraServicesImpl(SerraRepositori serraRepositori){
        this.serraRepositori = serraRepositori;
    }
    @Override
    public DTOSerra getSerra(Long idSerra) {
        final Serra nullSerra = new Serra() ;
        final Serra serra = serraRepositori.findById(idSerra).orElse(nullSerra);
        return mapper.toDtoSerra(serra);
    }

    @Override
    public DTOSerra saveSerra(DTOSerra dtoSerra) {
        Serra serra = serraRepositori.save(mapper.toSerra(dtoSerra));
        return mapper.toDtoSerra(serra);
    }
}
