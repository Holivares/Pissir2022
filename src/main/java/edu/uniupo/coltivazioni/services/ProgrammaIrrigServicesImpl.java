package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.ProgrammaIrrig;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.dto.DTOProgrammaIrrig;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.ProgrammaIritigRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DTOProgrammaIrrig geProgrammaIrrig ( Long idProgrammaIrrig ) {
        final ProgrammaIrrig nullProgrammaIrrig = new ProgrammaIrrig();
        final ProgrammaIrrig programmaIrrig = programmaIritigRepositori.findById( idProgrammaIrrig ).orElse( nullProgrammaIrrig );
        return mapper.programmaIrrigToDTOProgrammaIrrig( programmaIrrig );
    }

    @Override
    public DTOProgrammaIrrig saveProgramma ( DTOProgrammaIrrig dtoProgrammaIrrig ) {
        ProgrammaIrrig programmaIrrig = programmaIritigRepositori.save( mapper.dTOProgrammaIrrigToProgrammaIrrig( dtoProgrammaIrrig, new ProgrammaIrrig() ) );
        return mapper.programmaIrrigToDTOProgrammaIrrig( programmaIrrig );
    }

    @Override
    public DTOProgrammaIrrig updateProgramma ( DTOProgrammaIrrig dtoProgrammaIrrig ) {
        ProgrammaIrrig oldProgrammaIrrig = programmaIritigRepositori.findById( dtoProgrammaIrrig.getIdProgramma() ).orElse( new ProgrammaIrrig() );
        ProgrammaIrrig programmaIrrig = programmaIritigRepositori.save( mapper.dTOProgrammaIrrigToProgrammaIrrig( dtoProgrammaIrrig, oldProgrammaIrrig ) );
        return mapper.programmaIrrigToDTOProgrammaIrrig( programmaIrrig );
    }

    @Override
    public DTODeletedResponse deleteProgramma ( Long idProgrammaIrrig ) {
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse( true, "Programma Irrigation Deleted" );
        programmaIritigRepositori.findById( idProgrammaIrrig ).ifPresentOrElse( programmaIritigRepositori::delete, () -> {
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        } );
        return dtoDeletedResponse;
    }
}
