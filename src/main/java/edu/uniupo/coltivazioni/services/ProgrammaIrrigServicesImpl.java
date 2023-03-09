package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.ProgrammaIrrig;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOProgrammaIrrig;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.ProgrammaIritigRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author
 * @author
 */
@Service
public class ProgrammaIrrigServicesImpl implements ProgrammaIrrigServices {
    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );
    ProgrammaIritigRepositori programmaIritigRepositori;

    @Autowired
    public ProgrammaIrrigServicesImpl ( ProgrammaIritigRepositori programmaIritigRepositori ) {
        this.programmaIritigRepositori = programmaIritigRepositori;
    }

    @Override
    public DTOProgrammaIrrig getProgrammaIrrig ( Long idProgrammaIrrig ) {
        final ProgrammaIrrig programmaIrrig = programmaIritigRepositori.findById( idProgrammaIrrig ).orElse( new ProgrammaIrrig() );
        return mapper.toDtoProgrammaIrrig( programmaIrrig );
    }


    @Override
    public DTOProgrammaIrrig saveProgramma ( DTOProgrammaIrrig dtoProgrammaIrrig ) {
        ProgrammaIrrig NewProgramma = new ProgrammaIrrig();
        ProgrammaIrrig programmaIrrig = programmaIritigRepositori.save( NewProgramma);
        return mapper.toDtoProgrammaIrrig( programmaIrrig );
    }

    @Override
    public DTOProgrammaIrrig updateProgramma(DTOProgrammaIrrig dtoProgrammaIrrig) {
        ProgrammaIrrig oldProgramma = programmaIritigRepositori.findById(dtoProgrammaIrrig.getIdProgramma()).orElse(new ProgrammaIrrig());
        mapper.toProgrammaIrrig(dtoProgrammaIrrig,oldProgramma);
        ProgrammaIrrig programmaIrrig = programmaIritigRepositori.save(oldProgramma);
        return mapper.toDtoProgrammaIrrig(programmaIrrig);
    }

    @Override
    public DTODeletedResponse deleteProgramma(Long idProgramma) {
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse(true,"Programma Deleted");
        Optional<ProgrammaIrrig> deleteCondidateProgramma = programmaIritigRepositori.findById(idProgramma);
        deleteCondidateProgramma.ifPresentOrElse(deleteCondidate -> {
            System.out.println("deleteCondidate found = " + deleteCondidate.getIdProgramma() + " " + deleteCondidate.getDescrizione());
            programmaIritigRepositori.delete(deleteCondidate);
        }, () ->{
            System.out.println( "deleteCondidate not found ");
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        });
        return dtoDeletedResponse;
    }
}
