package edu.uniupo.coltivazioni.mapper;

import edu.uniupo.coltivazioni.dao.*;
import edu.uniupo.coltivazioni.dto.*;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author
 * @author
 */
//gerer les objets façon spring
@Mapper()
public abstract class ObjectMapper {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" );

    public abstract DTOAziendaAgricola toDtoAziendaAgricola ( AziendaAgricola aziendaAgricola );

    @Mapping( target = "idSerra", source = "attuatore.serra.idSerra" )
    public abstract DTOAttuatore toDtoAttuatore ( Attuatore attuatore );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "localDateTimeToString" )
    @Mapping( target = "idSerra", source = "misura.serra.idSerra" )
    public abstract DTOMisura toDtoMisura ( Misura misura );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "localDateTimeToString" )
    public abstract DTOProgrammaIrrig toDtoProgrammaIrrig ( ProgrammaIrrig programmaIrrig );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "localDateTimeToString" )
    @Mapping( target = "idSerra", source = "sensore.serra.idSerra" )
    public abstract DTOSensore toDtoSensore ( Sensore sensore );
    @InheritInverseConfiguration
    @Mapping( target = "idAziendaAgricola", source = "serra.aziendaAgricola.idAziendaAgricola" )
    public abstract DTOSerra toDtoSerra ( Serra serra );

    @InheritInverseConfiguration
    public abstract DTOTipoProgramma toDtoTipoProgramma ( TipoProgramma tipoProgramma );

    @InheritInverseConfiguration
    @Mapping( target = "idAziendaAgricola", source = "utente.aziendaAgricola.idAziendaAgricola" )
    public abstract DTOUtente toDtoUtente ( Utente utente );

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    public abstract void toAziendaAgricola ( DTOAziendaAgricola dtoAziendaAgricola, @MappingTarget AziendaAgricola aziendaAgricola );

    @Mapping( target = "serra.idSerra ", source = "idSerra" )
    public abstract Attuatore toAttuatore ( DTOAttuatore dtoAttuatore );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "stringToLocalDateTime" )
    @Mapping( target = "serra.idSerra ", source = "idSerra" )
    public abstract Misura toMisura ( DTOMisura dtoMisura );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "stringToLocalDateTime" )
    public abstract ProgrammaIrrig toProgrammaIrrig ( DTOProgrammaIrrig dtoProgrammaIrrig );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "stringToLocalDateTime" )
    @Mapping( target = "serra.idSerra ", source = "idSerra" )
    public abstract Sensore toSensore ( DTOSensore dtoSensore );

    @Mapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,target = "aziendaAgricola.idAziendaAgricola", source = "idAziendaAgricola" )
    public abstract void toSerra ( DTOSerra dtoSerra, @MappingTarget Serra serra );

    public abstract TipoProgramma toTipoProgramma ( DTOTipoProgramma dtoTipoProgramma );

    @Mapping( target = "aziendaAgricola.idAziendaAgricola", source = "idAziendaAgricola" )
    public abstract Utente toUtente ( DTOUtente dtoUtente );

    @Named( "stringToLocalDateTime" )
    public static LocalDateTime stringToLocalDateTime ( String date ) {
        if(date == null){
            return null;
        }
        return LocalDateTime.parse( date, DATE_FORMAT );
    }

    @Named( "localDateTimeToString" )
    public static String localDateTimeToString ( LocalDateTime date ) {
        if(date == null){
            return null;
        }

        return date.format( DATE_FORMAT );
    }

}
