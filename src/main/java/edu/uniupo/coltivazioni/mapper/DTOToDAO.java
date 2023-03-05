package edu.uniupo.coltivazioni.mapper;

import edu.uniupo.coltivazioni.dao.*;
import edu.uniupo.coltivazioni.dto.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


/**
 * @author
 * @author
 */
//gerer les objets façon spring
@Mapper(componentModel = "spring")
public interface DTOToDAO {
    //methode qui mapp les objets du DAO pour les faire correspondre au DTO
    @InheritInverseConfiguration
    DTOAziendaAgricola toDtoAziendaAgricola(AziendaAgricola aziendaAgricola);

    @InheritInverseConfiguration
    DTOAttuatore toDtoAttuatore(Attuatore attuatore);

    @InheritInverseConfiguration
    @Mapping(target = "dateTime", source = "dateTime")
    DTOMisura toDtoMisura(Misura misura);
    @InheritInverseConfiguration
    DTOProgrammaIrrig toDtoProgrammaIrrig(ProgrammaIrrig programmaIrrig);

    @InheritInverseConfiguration
    @Mapping(target = "dateTime", source = "dateTime")
    DTOSensore toDtoSensore(Sensore sensore);
    @InheritInverseConfiguration
    DTOSerra toDtoSerra(Serra serra);
    @InheritInverseConfiguration
    DTOTipoProgramma toDtoTipoProgramma(TipoProgramma tipoProgramma);
    @InheritInverseConfiguration
    DTOUtente toDtoUtente(Utente utente);



    AziendaAgricola toAziendaAgricola(DTOAziendaAgricola dtoAziendaAgricola);

    Attuatore toAttuatore(DTOAttuatore dtoAttuatore);

    Misura toMisura(DTOMisura dtoMisura);

    ProgrammaIrrig toProgrammaIrrig(DTOProgrammaIrrig dtoProgrammaIrrig);


    Sensore toSensore(DTOSensore dtoSensore);

    Serra toSerra(DTOSerra dtoSerra);

    TipoProgramma toTipoProgramma(DTOTipoProgramma dtoTipoProgramma);

    Utente toUtente(DTOUtente dtoUtente);



}
