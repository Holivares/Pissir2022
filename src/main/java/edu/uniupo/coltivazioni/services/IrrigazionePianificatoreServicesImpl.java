package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.dto.DTOIrrigazionePianificatore;
import edu.uniupo.coltivazioni.entities.IrrigazionePianificatore;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.IrrigazionePianificatoreRepositori;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author
 * @author
 */
@Service
public class IrrigazionePianificatoreServicesImpl implements IrrigazionePianificatoreServices{

   private final IrrigazionePianificatoreRepositori irrigazionePianificatoreRepositori;
   private final ObjectMapper mapper = Mappers.getMapper(ObjectMapper.class);
    @Autowired
    public IrrigazionePianificatoreServicesImpl(IrrigazionePianificatoreRepositori irrigazionePianificatoreRepositori) {
        this.irrigazionePianificatoreRepositori = irrigazionePianificatoreRepositori;
    }

    @Override
    public DTOIrrigazionePianificatore createIrrigazionePianificatore(DTOIrrigazionePianificatore dtoIrrigazionePianificatore) {
        IrrigazionePianificatore pianificatore = irrigazionePianificatoreRepositori.save(mapper.dTOIrrigazionePianificatoreTOIrrigazionePianificatore(dtoIrrigazionePianificatore));
        return mapper.irrigazionePianificatoreTODTOIrrigazionePianificatore(pianificatore);
    }

    @Override
    public DTOIrrigazionePianificatore updateIrrigazionePianificatore(DTOIrrigazionePianificatore dtoIrrigazionePianificatore) {
        IrrigazionePianificatore pianificatore = irrigazionePianificatoreRepositori.save(mapper.dTOIrrigazionePianificatoreTOIrrigazionePianificatore(dtoIrrigazionePianificatore));
        return mapper.irrigazionePianificatoreTODTOIrrigazionePianificatore(pianificatore);
    }

    @Override
    public DTODeleteResponse deleteIrrigazionePianificatoreById(UUID idIrrigazionePianificatore) {
            irrigazionePianificatoreRepositori.deleteById(idIrrigazionePianificatore);
            return new DTODeleteResponse("Piano irrigazione is deleted", true);
    }


    @Override
    public DTOIrrigazionePianificatore findIrrigazionePianificatoreByIdAziendaAgricola(UUID idAziendaAgricola) {
        Optional<IrrigazionePianificatore>pianificatore = irrigazionePianificatoreRepositori.findByAziendaAgricolaIdAziendaAgricola(idAziendaAgricola);
        return mapper.irrigazionePianificatoreTODTOIrrigazionePianificatore(pianificatore.orElse(new IrrigazionePianificatore()));
    }

    @Override
    public DTOIrrigazionePianificatore findIrrigazionePianificatoreByIdserra(UUID idSerra) {
       Optional<IrrigazionePianificatore> pianificatore = irrigazionePianificatoreRepositori.findBySerraidSerra(idSerra);
        return mapper.irrigazionePianificatoreTODTOIrrigazionePianificatore(pianificatore.orElse(new IrrigazionePianificatore()));
    }
}
