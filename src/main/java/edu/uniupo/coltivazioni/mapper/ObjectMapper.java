package edu.uniupo.coltivazioni.mapper;

import edu.uniupo.coltivazioni.dto.*;
import edu.uniupo.coltivazioni.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author
 * @author
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ObjectMapper {
    //Converti un dao en dto
    abstract DTOAttuatore attuatoreToDTOAttuatore(Attuatore attuatore);
    abstract DTOSerra serraToDTOSerra(Serra serra);
    abstract DTOStatoAttuatore statoAttuatoreToDTOStatoAttuatore(StatoAttuatore statoAttuatore);
    abstract DTOTipoAttuatore tipoAttuatoreToDTOTipoAttuatore(TipoAttuatore tipoAttuatore);
    abstract DTOAttuatoreMode attuatoreModeTODTOAttuatoreMode(AttuatoreMode attuatoreMode);
    abstract DTOAttuatoreStato attuatoreStatoTODTOAttuatoreStato(AttuatoreStato attuatoreStato);
    abstract DTOUtente utenteTODTOUtente(Utente utente);
    abstract DTOAziendaAgricola aziendaAgricolaTODTOAziendaAgricola(AziendaAgricola aziendaAgricola);
    abstract DTOSensore sensoreTODTOSensore(Sensore sensore);
    abstract DTOIrrigazionePianificatore irrigazionePianificatoreTODTOIrrigazionePianificatore(IrrigazionePianificatore irrigazionePianificatore);
    abstract DTOMisura misuraTODTOMisura(Misura misura);
    abstract DTORuolo ruoloTODTORuolo(Ruolo ruolo);
    abstract DTOExecutionTime executionTimeTODTOExecutionTime(ExecutionTime executionTime);

    //converti dto en dao

    abstract Attuatore dTOAttuatoreToAttuatore(DTOAttuatore dtoAttuatore);
    abstract DTOSerra dTOSerraToSerra(DTOSerra DtoSerra);
    abstract DTOStatoAttuatore dTOStatoAttuatoreToStatoAttuatore(DTOStatoAttuatore dtoStatoAttuatore);
    abstract DTOTipoAttuatore dTOTipoAttuatoreToTipoAttuatore(DTOTipoAttuatore dtoTipoAttuatore);
    abstract DTOAttuatoreMode dTOAttuatoreModeTOAttuatoreMode(DTOAttuatoreMode dtoAttuatoreMode);
    abstract DTOAttuatoreStato dTOAttuatoreStatoTOAttuatoreStato(DTOAttuatoreStato dtoAttuatoreStato);
    abstract DTOUtente dTOUtenteTOUtente(DTOUtente dtoUtente);
    abstract DTOAziendaAgricola dTOAziendaAgricolaTOAziendaAgricola(DTOAziendaAgricola dtoAziendaAgricola);
    abstract DTOSensore dTOSensoreTOSensore(DTOSensore dtoSensore);
    abstract DTOIrrigazionePianificatore dTOIrrigazionePianificatoreTOIrrigazionePianificatore(DTOIrrigazionePianificatore dtoIrrigazionePianificatore);
    abstract DTOMisura dTOMisuraTOMisura(DTOMisura dtoMisura);
    abstract DTORuolo dTORuoloTORuolo(DTORuolo dtoRuolo);
    abstract DTOExecutionTime dTOExecutionTimeTOExecutionTime(DTOExecutionTime dtoExecutionTime);

}
