package edu.uniupo.coltivazioni.mapper;

import edu.uniupo.coltivazioni.dto.*;
import edu.uniupo.coltivazioni.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author
 * @author
 */
@Mapper()
public abstract class ObjectMapper {
    //Converti un dao en dto
    @Mapping( target = "idSerra", source = "serra.idSerra" )
    public abstract DTOAttuatore attuatoreToDTOAttuatore ( Attuatore attuatore );

    @Mapping( target = "idAziendaAgricola", source = "aziendaAgricola.idAziendaAgricola" )
    public abstract DTOSerra serraToDTOSerra ( Serra serra );

    public abstract DTOStatoAttuatore statoAttuatoreToDTOStatoAttuatore ( StatoAttuatore statoAttuatore );

    public abstract DTOTipoAttuatore tipoAttuatoreToDTOTipoAttuatore ( TipoAttuatore tipoAttuatore );

    public abstract DTOAttuatoreMode attuatoreModeTODTOAttuatoreMode ( AttuatoreMode attuatoreMode );

    public abstract DTOAttuatoreStato attuatoreStatoTODTOAttuatoreStato ( AttuatoreStato attuatoreStato );

    public abstract DTOUtente utenteTODTOUtente ( Utente utente );

    @Mapping( target = "idUtente", source = "utente.idUtente" )
    public abstract DTOAziendaAgricola aziendaAgricolaTODTOAziendaAgricola ( AziendaAgricola aziendaAgricola );

    @Mapping( target = "idSerra", source = "serra.idSerra" )
    public abstract DTOSensore sensoreTODTOSensore ( Sensore sensore );

    @Mapping( target = "idAziendaAgricola", source = "aziendaAgricola.idAziendaAgricola" )
    @Mapping( target = "idSerra", source = "serra.idSerra" )
    public abstract DTOIrrigazionePianificatore irrigazionePianificatoreTODTOIrrigazionePianificatore ( IrrigazionePianificatore irrigazionePianificatore );

    @Mapping( target = "idSensore", source = "sensore.idSensore" )
    public abstract DTOMisura misuraTODTOMisura ( Misura misura );

    public abstract DTORuolo ruoloTODTORuolo ( Ruolo ruolo );

    public abstract DTOExecutionTime executionTimeTODTOExecutionTime ( ExecutionTime executionTime );

    //converti dto en dao
    @Mapping( target = "serra.idSerra", source = "idSerra" )
    public abstract Attuatore dTOAttuatoreToAttuatore ( DTOAttuatore dtoAttuatore );

    @Mapping( target = "aziendaAgricola.idAziendaAgricola", source = "idAziendaAgricola" )
    public abstract Serra dTOSerraToSerra ( DTOSerra DtoSerra );

    public abstract StatoAttuatore dTOStatoAttuatoreToStatoAttuatore ( DTOStatoAttuatore dtoStatoAttuatore );

    public abstract TipoAttuatore dTOTipoAttuatoreToTipoAttuatore ( DTOTipoAttuatore dtoTipoAttuatore );

    public abstract AttuatoreMode dTOAttuatoreModeTOAttuatoreMode ( DTOAttuatoreMode dtoAttuatoreMode );

    public abstract AttuatoreStato dTOAttuatoreStatoTOAttuatoreStato ( DTOAttuatoreStato dtoAttuatoreStato );

    public abstract Utente dTOUtenteTOUtente ( DTOUtente dtoUtente );

    @Mapping( target = "utente.idUtente", source = "idUtente" )
    public abstract AziendaAgricola dTOAziendaAgricolaTOAziendaAgricola ( DTOAziendaAgricola dtoAziendaAgricola );

    @Mapping( target = "serra.idSerra", source = "idSerra" )
    public abstract Sensore dTOSensoreTOSensore ( DTOSensore dtoSensore );

    @Mapping( target = "aziendaAgricola.idAziendaAgricola", source = "idAziendaAgricola" )
    @Mapping( target = "serra.idSerra", source = "idSerra" )
    public abstract IrrigazionePianificatore dTOIrrigazionePianificatoreTOIrrigazionePianificatore ( DTOIrrigazionePianificatore dtoIrrigazionePianificatore );

    @Mapping( target = "sensore.idSensore", source = "idSensore" )
    public abstract Misura dTOMisuraTOMisura ( DTOMisura dtoMisura );

    public abstract Ruolo dTORuoloTORuolo ( DTORuolo dtoRuolo );

    public abstract ExecutionTime dTOExecutionTimeTOExecutionTime ( DTOExecutionTime dtoExecutionTime );

}
