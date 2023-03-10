package edu.uniupo.coltivazioni.mapper;

import edu.uniupo.coltivazioni.dao.*;
import edu.uniupo.coltivazioni.dto.*;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @author
 */
//gerer les objets façon spring
@Mapper()
public abstract class ObjectMapper {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" );

    public abstract DTOAziendaAgricola aziendaAgricolaToDTOAziendaAgricola ( AziendaAgricola aziendaAgricola );

    @Mapping( target = "idSerra", source = "attuatore.serra.idSerra" )
    public abstract DTOAttuatore attuatoreToDTOAttuatore ( Attuatore attuatore );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "localDateTimeToString" )
    @Mapping( target = "idSerra", source = "misura.serra.idSerra" )
    public abstract DTOMisura misuraToDTOMisura ( Misura misura );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "localDateTimeToString" )
    public abstract DTOProgrammaIrrig programmaIrrigToDTOProgrammaIrrig ( ProgrammaIrrig programmaIrrig );

    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "localDateTimeToString" )
    @Mapping( target = "idSerra", source = "sensore.serra.idSerra" )
    public abstract DTOSensore sensoreToDTOSensore ( Sensore sensore );

    @Mapping( target = "idAziendaAgricola", source = "serra.aziendaAgricola.idAziendaAgricola" )
    public abstract DTOSerra serraToDTOSerra ( Serra serra );

    public abstract DTOTipoProgramma tipoProgrammaToDTOTipoProgramma ( TipoProgramma tipoProgramma );

    @Mapping( target = "idAziendaAgricola", source = "utente.aziendaAgricola.idAziendaAgricola" )
    public abstract DTOUtente utenteToDTOUtente ( Utente utente );

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    public abstract AziendaAgricola dTOAziendaAgricolaToAziendaAgricola ( DTOAziendaAgricola dtoAziendaAgricola, @MappingTarget AziendaAgricola aziendaAgricola );

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    @Mapping( target = "serra.idSerra", source = "idSerra" )
    public abstract Attuatore dTOAttuatoreToAttuatore ( DTOAttuatore dtoAttuatore, @MappingTarget Attuatore attuatore );

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "stringToLocalDateTime" )
    @Mapping( target = "serra.idSerra", source = "idSerra" )
    public abstract Misura dTOMisuraToMisura ( DTOMisura dtoMisura, @MappingTarget Misura misura );

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "stringToLocalDateTime" )
    public abstract ProgrammaIrrig dTOProgrammaIrrigToProgrammaIrrig ( DTOProgrammaIrrig dtoProgrammaIrrig, @MappingTarget ProgrammaIrrig programmaIrrig );

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    @Mapping( target = "dateTime", source = "dateTime", qualifiedByName = "stringToLocalDateTime" )
    @Mapping( target = "serra.idSerra", source = "idSerra" )
    public abstract Sensore dTOSensoreToSensore ( DTOSensore dtoSensore, @MappingTarget Sensore sensore );

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    @Mapping( target = "aziendaAgricola.idAziendaAgricola", source = "idAziendaAgricola" )
    public abstract Serra dTOSerraToSerra ( DTOSerra dtoSerra, @MappingTarget Serra serra );

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    public abstract TipoProgramma dTOTipoProgrammaToTipoProgramma ( DTOTipoProgramma dtoTipoProgramma );

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    @Mapping( target = "aziendaAgricola.idAziendaAgricola", source = "idAziendaAgricola" )
    public abstract Utente dTOUtenteToUtente ( DTOUtente dtoUtente, @MappingTarget Utente utente );

    public List<Serra> dTOSerraListToSerraList ( List<DTOSerra> list ) {
        List<Serra> serraList = new ArrayList<>( list.size() );
        for( DTOSerra element : list ) {
            Serra candidateSerraForAddToList = new Serra();
            dTOSerraToSerra( element, candidateSerraForAddToList );
            serraList.add( candidateSerraForAddToList );
        }
        return serraList;
    }

    public List<Utente> dTOUtenteListToUtenteList ( List<DTOUtente> list ) {
        List<Utente> utenteList = new ArrayList<>( list.size() );
        for( DTOUtente element : list ) {
            Utente candidateUtenteForAddTList = new Utente();
            dTOUtenteToUtente( element, candidateUtenteForAddTList );
            utenteList.add( candidateUtenteForAddTList );
        }
        return utenteList;
    }

    public List<Attuatore> dTOAttuatoreListToAttuatoreList ( List<DTOAttuatore> list ) {
        List<Attuatore> attuatorelist = new ArrayList<>( list.size() );
        for( DTOAttuatore element : list ) {
            Attuatore candidateAttuatoreForAddTList = new Attuatore();
            dTOAttuatoreToAttuatore( element, candidateAttuatoreForAddTList );
            attuatorelist.add( candidateAttuatoreForAddTList );
        }
        return attuatorelist;
    }

    public List<Misura> dTOMisuraListToMisuraList ( List<DTOMisura> list ) {
        List<Misura> misuralist = new ArrayList<>( list.size() );
        for( DTOMisura element : list ) {
            Misura candidateMisuraForAddTList = new Misura();
            dTOMisuraToMisura( element, candidateMisuraForAddTList );
            misuralist.add( candidateMisuraForAddTList );
        }
        return misuralist;
    }

    public List<Sensore> dTOSensoreListToSensoreList ( List<DTOSensore> list ) {
        List<Sensore> misuralist = new ArrayList<>( list.size() );
        for( DTOSensore element : list ) {
            Sensore candidateSensoreForAddTList = new Sensore();
            dTOSensoreToSensore( element, candidateSensoreForAddTList );
            misuralist.add( candidateSensoreForAddTList );
        }
        return misuralist;
    }

    @Named( "stringToLocalDateTime" )
    public static LocalDateTime stringToLocalDateTime ( String date ) {
        if( date == null ) {
            return null;
        }
        return LocalDateTime.parse( date, DATE_FORMAT );
    }

    @Named( "localDateTimeToString" )
    public static String localDateTimeToString ( LocalDateTime date ) {
        if( date == null ) {
            return null;
        }

        return date.format( DATE_FORMAT );
    }

}
