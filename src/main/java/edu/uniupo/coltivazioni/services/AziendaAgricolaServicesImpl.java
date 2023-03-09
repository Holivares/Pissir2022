package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dao.AziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTOAziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTODeletedResponse;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.AziendaAgricolaRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author
 * @author
 */
//Disce cosa farà il metodo
//Une seule implementation pour une classe
@Service
public class AziendaAgricolaServicesImpl implements AziendaAgricolaServices {
    //Recupère toutes les methodes des classes et les mettre dans l'objet mapper
    private final ObjectMapper mapper = Mappers.getMapper( ObjectMapper.class );

    private AziendaAgricolaRepositori aziendaAgricolaRepositori;

    //injection de dependances della DB
    //va rechercher dans mon code la classe qui implemente cette interface, vu que l'on ne peut pas créer une instance d'une interface...
    @Autowired
    public AziendaAgricolaServicesImpl ( AziendaAgricolaRepositori aziendaAgricolaRepositori ) {
        this.aziendaAgricolaRepositori = aziendaAgricolaRepositori;
    }

    @Override
    public DTOAziendaAgricola getAziendaAgricola ( Long idAziendaAgricola ) {
        final AziendaAgricola aziendaAgricola = aziendaAgricolaRepositori.findById( idAziendaAgricola ).orElse( new AziendaAgricola() );
        return mapper.toDtoAziendaAgricola( aziendaAgricola );
    }

    @Override
    public DTOAziendaAgricola saveAzienda ( DTOAziendaAgricola dtoAziendaAgricola ) {
        AziendaAgricola NewAziendaAgricola = new AziendaAgricola();
        mapper.toAziendaAgricola( dtoAziendaAgricola, NewAziendaAgricola );
        System.out.println("NewAziendaAgricola.toString() = " + NewAziendaAgricola.toString());
        AziendaAgricola aziendaAgricola = aziendaAgricolaRepositori.save( NewAziendaAgricola );
        return mapper.toDtoAziendaAgricola( aziendaAgricola );

    }

    @Override
    public DTOAziendaAgricola updateAzienda ( DTOAziendaAgricola dtoAziendaAgricola ) {
        AziendaAgricola oldAziendaAgricola = aziendaAgricolaRepositori.findById( dtoAziendaAgricola.getIdAziendaAgricola() ).orElse( new AziendaAgricola() );
        mapper.toAziendaAgricola( dtoAziendaAgricola, oldAziendaAgricola );
        AziendaAgricola aziendaAgricola = aziendaAgricolaRepositori.save( oldAziendaAgricola );
        return mapper.toDtoAziendaAgricola( aziendaAgricola );
    }

    @Override
    public DTODeletedResponse deleteAzienda ( Long idAziendaAgricola ) {
        DTODeletedResponse dtoDeletedResponse = new DTODeletedResponse(true, "Azienda Agricola Deleted");
        Optional<AziendaAgricola> deleteCondidateAziendaAgricola = aziendaAgricolaRepositori.findById( idAziendaAgricola );
        deleteCondidateAziendaAgricola.ifPresentOrElse( deleteCondidate -> {
            System.out.println( "deleteCondidate found = " + deleteCondidate.getIdAziendaAgricola() + " " + deleteCondidate.getDescrizione());
            aziendaAgricolaRepositori.delete( deleteCondidate );
        }, () -> {
            System.out.println( "deleteCondidate not found ");
            dtoDeletedResponse.setDeletionStatus( false );
            dtoDeletedResponse.setMessage( "Data not found" );
        } );
        return dtoDeletedResponse;
    }


}
