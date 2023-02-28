package edu.uniupo.coltivazioni.services;
import edu.uniupo.coltivazioni.dao.Serra;
import edu.uniupo.coltivazioni.repositori.SerraRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @author
 */
@Service
public class SerraServicesImpl implements SerraServices{

    SerraRepositori serraRepositori;
    @Autowired
    public SerraServicesImpl(SerraRepositori serraRepositori){
        this.serraRepositori = serraRepositori;
    }
    @Override
    public Serra getSerra(Long id) {
        final Serra serra = new Serra() ;
        return serraRepositori.findById(id).orElse(serra);
    }
}
