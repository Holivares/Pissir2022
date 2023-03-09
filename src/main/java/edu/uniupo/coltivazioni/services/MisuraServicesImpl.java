package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.Misura;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOMisura;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.MisuraRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author
 * @author
 */
@Service
public class MisuraServicesImpl implements MisuraServices {
    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    MisuraRepositori misuraRepositori;

    @Autowired
    public MisuraServicesImpl ( MisuraRepositori misuraRepositori ) {
        this.misuraRepositori = misuraRepositori;
    }

    @Override
    public DTOMisura getMisura ( Long idMisura ) {
        final Misura nullMisura = new Misura();
        final Misura misura = misuraRepositori.findById( idMisura ).orElse( nullMisura );

        return mapper.toDtoMisura( misura );
    }

    @Override
    public DTOMisura saveMisura ( DTOMisura dtoMisura ) {
        Misura NewMisura = new Misura();
        mapper.toMisura(dtoMisura, NewMisura);
        Misura misura = misuraRepositori.save( NewMisura);
        return mapper.toDtoMisura( misura );
    }
    @Override
    public DTOMisura updateMisura(DTOMisura dtoMisura){
        Misura oldMisura = misuraRepositori.findById(dtoMisura.getIdMisura()).orElse(new Misura());
        mapper.toMisura(dtoMisura, oldMisura);
        Misura misura = misuraRepositori.save(oldMisura);
        return mapper.toDtoMisura(misura);
    }
    @Override
    public DTODeletedResponse deleteMisura(Long idMisura){
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse(true,"Misurs Deleted");
        Optional<Misura> deleteCondidateMisura = misuraRepositori.findById(idMisura);
        deleteCondidateMisura.ifPresentOrElse(deleteCondidate -> {
            System.out.println("deleteCondidate found = " + deleteCondidate.getIdMisura() + " " + deleteCondidate.getMisurazioni());
            misuraRepositori.delete(deleteCondidate);
        }, () ->{
            System.out.println( "deleteCondidate not found ");
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        });
        return dtoDeletedResponse;
    }
}
