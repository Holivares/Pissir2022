package edu.uniupo.coltivazioni.services;

import edu.uniupo.coltivazioni.dto.DTOAziendaAgricola;
import edu.uniupo.coltivazioni.dto.DTODeleteResponse;
import edu.uniupo.coltivazioni.entities.AziendaAgricola;
import edu.uniupo.coltivazioni.mapper.ObjectMapper;
import edu.uniupo.coltivazioni.repositori.AziendaAgricolaRepositori;
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
public class AziendaAgricolaServicesImpl implements AziendaAgricolaServices{
    private final AziendaAgricolaRepositori aziendaAgricolaRepositori;
    private final ObjectMapper mapper = Mappers.getMapper(ObjectMapper.class);
    @Autowired
    public AziendaAgricolaServicesImpl(AziendaAgricolaRepositori aziendaAgricolaRepositori){
        this.aziendaAgricolaRepositori = aziendaAgricolaRepositori;
    }

    @Override
    public DTOAziendaAgricola createAziendaAgricola(DTOAziendaAgricola dtoAziendaAgricola) {
       AziendaAgricola azienda = aziendaAgricolaRepositori.save(mapper.dTOAziendaAgricolaTOAziendaAgricola(dtoAziendaAgricola));
        return mapper.aziendaAgricolaTODTOAziendaAgricola(azienda);
    }

    @Override
    public DTOAziendaAgricola updateAziendaAgricola(DTOAziendaAgricola dtoAziendaAgricola) {
        AziendaAgricola azienda = aziendaAgricolaRepositori.save(mapper.dTOAziendaAgricolaTOAziendaAgricola(dtoAziendaAgricola));
        return mapper.aziendaAgricolaTODTOAziendaAgricola(azienda);
    }

    @Override
    public DTODeleteResponse deleteAziendaAgricola(UUID idAziendaAgricola) {
        aziendaAgricolaRepositori.deleteById(idAziendaAgricola);
        // TODO: is possibile to verify that the element is really deleted in DB
        return new DTODeleteResponse("Azienda Agricola is deleted",true);
    }


    @Override
    public DTOAziendaAgricola findAziendaAgricolaByIdUser(UUID idUtente) {
        Optional<AziendaAgricola> azienda = aziendaAgricolaRepositori.findByUtenteidUtente(idUtente);
        return mapper.aziendaAgricolaTODTOAziendaAgricola(azienda.orElse(new AziendaAgricola()));
    }

    @Override
    public DTOAziendaAgricola findAziendaAgricolaById(UUID idAziendaAgricola) {
        Optional<AziendaAgricola> azienda = aziendaAgricolaRepositori.findById(idAziendaAgricola);
        return mapper.aziendaAgricolaTODTOAziendaAgricola(azienda.orElse(new AziendaAgricola()));
    }

    @Override
    public DTOAziendaAgricola findAziendaAgricolaByName(String nome) {
        Optional<AziendaAgricola> azienda = aziendaAgricolaRepositori.findByNome(nome);
        return mapper.aziendaAgricolaTODTOAziendaAgricola(azienda.orElse(new AziendaAgricola()));
    }
}
