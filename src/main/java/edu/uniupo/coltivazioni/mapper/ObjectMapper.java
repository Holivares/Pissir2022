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
    public abstract DTOAttuatore attuatoreToDTOAttuatore(Attuatore attuatore);
    public abstract DTOSerra serraToDTOSerra(Serra serra);
    public abstract DTOStatoAttuatore statoAttuatoreToDTOStatoAttuatore(StatoAttuatore statoAttuatore);
    public abstract DTOTipoAttuatore tipoAttuatoreToDTOTipoAttuatore(TipoAttuatore tipoAttuatore);
    public abstract DTOAttuatoreMode attuatoreModeTODTOAttuatoreMode(AttuatoreMode attuatoreMode);
    public abstract DTOAttuatoreStato attuatoreStatoTODTOAttuatoreStato(AttuatoreStato attuatoreStato);
    public abstract DTOUtente utenteTODTOUtente(Utente utente);
    public abstract DTOAziendaAgricola aziendaAgricolaTODTOAziendaAgricola(AziendaAgricola aziendaAgricola);
    public abstract DTOSensore sensoreTODTOSensore(Sensore sensore);
    public abstract DTOIrrigazionePianificatore irrigazionePianificatoreTODTOIrrigazionePianificatore(IrrigazionePianificatore irrigazionePianificatore);
    public abstract DTOMisura misuraTODTOMisura(Misura misura);
    public abstract DTORuolo ruoloTODTORuolo(Ruolo ruolo);
    public abstract DTOExecutionTime executionTimeTODTOExecutionTime(ExecutionTime executionTime);

    //converti dto en dao

    public abstract Attuatore dTOAttuatoreToAttuatore(DTOAttuatore dtoAttuatore);
    public abstract Serra dTOSerraToSerra(DTOSerra DtoSerra);
    public abstract StatoAttuatore dTOStatoAttuatoreToStatoAttuatore(DTOStatoAttuatore dtoStatoAttuatore);
    public abstract TipoAttuatore dTOTipoAttuatoreToTipoAttuatore(DTOTipoAttuatore dtoTipoAttuatore);
    public abstract AttuatoreMode dTOAttuatoreModeTOAttuatoreMode(DTOAttuatoreMode dtoAttuatoreMode);
    public abstract AttuatoreStato dTOAttuatoreStatoTOAttuatoreStato(DTOAttuatoreStato dtoAttuatoreStato);
    public abstract Utente dTOUtenteTOUtente(DTOUtente dtoUtente);
    public abstract AziendaAgricola dTOAziendaAgricolaTOAziendaAgricola(DTOAziendaAgricola dtoAziendaAgricola);
    public abstract Sensore dTOSensoreTOSensore(DTOSensore dtoSensore);
    public abstract IrrigazionePianificatore dTOIrrigazionePianificatoreTOIrrigazionePianificatore(DTOIrrigazionePianificatore dtoIrrigazionePianificatore);
    public abstract Misura dTOMisuraTOMisura(DTOMisura dtoMisura);
    public abstract Ruolo dTORuoloTORuolo(DTORuolo dtoRuolo);
    public abstract ExecutionTime dTOExecutionTimeTOExecutionTime(DTOExecutionTime dtoExecutionTime);

}
