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

    //methode qui mapp les objets du DAO pour les faire correspondre au DTO
    @InheritInverseConfiguration
    public abstract DTOAziendaAgricola toDtoAziendaAgricola ( AziendaAgricola aziendaAgricola );

    @InheritInverseConfiguration
    public abstract DTOAttuatore toDtoAttuatore ( Attuatore attuatore );

    @InheritInverseConfiguration
    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "localDateTimeToString" )
    public abstract DTOMisura toDtoMisura ( Misura misura );

    @InheritInverseConfiguration
    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "localDateTimeToString" )
    public abstract DTOProgrammaIrrig toDtoProgrammaIrrig ( ProgrammaIrrig programmaIrrig );

    @InheritInverseConfiguration
    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "localDateTimeToString" )
    public abstract DTOSensore toDtoSensore ( Sensore sensore );

    @InheritInverseConfiguration
    public abstract DTOSerra toDtoSerra ( Serra serra );

    @InheritInverseConfiguration
    public abstract DTOTipoProgramma toDtoTipoProgramma ( TipoProgramma tipoProgramma );

    @InheritInverseConfiguration
    public abstract DTOUtente toDtoUtente ( Utente utente );

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    public abstract void toAziendaAgricola ( DTOAziendaAgricola dtoAziendaAgricola, @MappingTarget AziendaAgricola aziendaAgricola );

    public abstract Attuatore toAttuatore ( DTOAttuatore dtoAttuatore );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "stringToLocalDateTime" )
    public abstract Misura toMisura ( DTOMisura dtoMisura );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "stringToLocalDateTime" )
    public abstract ProgrammaIrrig toProgrammaIrrig ( DTOProgrammaIrrig dtoProgrammaIrrig );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "stringToLocalDateTime" )
    public abstract Sensore toSensore ( DTOSensore dtoSensore );

    public abstract Serra toSerra ( DTOSerra dtoSerra );

    public abstract TipoProgramma toTipoProgramma ( DTOTipoProgramma dtoTipoProgramma );

    public abstract Utente toUtente ( DTOUtente dtoUtente );

    @Named( "stringToLocalDateTime" )
    public static LocalDateTime stringToLocalDateTime ( String date ) {
        return LocalDateTime.parse( date, DATE_FORMAT );
    }

    @Named( "localDateTimeToString" )
    public static String localDateTimeToString ( LocalDateTime date ) {
        return date.format( DATE_FORMAT );
    }

}
