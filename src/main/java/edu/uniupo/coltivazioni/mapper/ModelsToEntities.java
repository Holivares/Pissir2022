package edu.uniupo.coltivazioni.mapper;

import edu.uniupo.coltivazioni.entity.*;
import edu.uniupo.coltivazioni.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper()
public abstract class ModelsToEntities {
    //Converti un dao en dto
    @Mapping( target = "idSerra", source = "serraEntity.idSerra" )
    public abstract AttuatoreModel entityToModelOfAttuatore ( AttuatoreEntity attuatoreEntity );

    @Mapping( target = "idAziendaAgricola", source = "aziendaAgricolaEntity.idAziendaAgricola" )
    public abstract SerraModel entityToModelOfSerra ( SerraEntity serraEntity );

    public abstract StatoAttuatoreModel entityToModelOfAttuatore ( StatoAttuatoreEntity statoAttuatoreEntity );

    public abstract TipoAttuatoreModel entityToModelOfTipoAttuatore ( TipoAttuatoreEntity tipoAttuatoreEntity );

    public abstract AttuatoreModeModel entityToModelOfAttuatoreMode ( AttuatoreModeEntity attuatoreModeEntity );

    public abstract AttuatoreStatoModel entityToModelOfAttuatoreStato ( AttuatoreStatoEntity attuatoreStatoEntity );

    public abstract UtenteModel entityToModelOfUtente ( UtenteEntity utenteEntity );

    @Mapping( target = "idUtente", source = "utenteEntity.idUtente" )
    public abstract AziendaAgricolaModel entityToModelOfAziendaAgricola ( AziendaAgricolaEntity aziendaAgricolaEntity );

    @Mapping( target = "idSerra", source = "serraEntity.idSerra" )
    public abstract SensoreModel entityToModelOfSensore ( SensoreEntity sensoreEntity );

    @Mapping( target = "idAziendaAgricola", source = "aziendaAgricolaEntity.idAziendaAgricola" )
    @Mapping( target = "idSerra", source = "serraEntity.idSerra" )
    public abstract IrrigazionePianificatoreModel entityToModelOfIrrigazionePianificatore ( IrrigazionePianificatoreEntity irrigazionePianificatoreEntity );

    @Mapping( target = "idSensore", source = "sensoreEntity.idSensore" )
    public abstract MisuraModel entityToModelOfMisura ( MisuraEntity misuraEntity );

    public abstract RuoloModel entityToModelOfRuolo ( RuoloEntity ruoloEntity );

    public abstract ExecutionTimeModel entityToModelOfExecutionTime ( ExecutionTimeEntity executionTimeEntity );

    //converti dto en dao
    @Mapping( target = "serraEntity.idSerra", source = "idSerra" )
    @Mapping( target = "serraEntity", ignore = true )
    public abstract AttuatoreEntity modelToEntityOfAttuatore ( AttuatoreModel attuatoreModel );

    @Mapping( target = "aziendaAgricolaEntity.idAziendaAgricola", source = "idAziendaAgricola" )
    @Mapping( target = "aziendaAgricolaEntity", ignore = true )
    public abstract SerraEntity modelToEntityOfSerra ( SerraModel serraModel );

    public abstract StatoAttuatoreEntity modelToEntityOfStatoAttuatore ( StatoAttuatoreModel statoAttuatoreModel );

    public abstract TipoAttuatoreEntity modelToEntityOfTipoAttuatore ( TipoAttuatoreModel tipoAttuatoreModel );

    public abstract AttuatoreModeEntity modelToEntityOfAttuatoreMode ( AttuatoreModeModel attuatoreModeModel );

    public abstract AttuatoreStatoEntity modelToEntityOfAttuatoreStato ( AttuatoreStatoModel attuatoreStatoModel );

    public abstract UtenteEntity modelToEntityOfUtente ( UtenteModel utenteModel );

    @Mapping( target = "utenteEntity.idUtente", source = "idUtente" )
    @Mapping( target = "utenteEntity", ignore = true )
    public abstract AziendaAgricolaEntity modelToEntityOfAziendaAgricola ( AziendaAgricolaModel aziendaAgricolaModel );

    @Mapping( target = "serraEntity.idSerra", source = "idSerra" )
    @Mapping( target = "serraEntity", ignore = true )
    public abstract SensoreEntity modelToEntityOfSensore ( SensoreModel sensoreModel );

    @Mapping( target = "aziendaAgricolaEntity.idAziendaAgricola", source = "idAziendaAgricola" )
    @Mapping( target = "serraEntity.idSerra", source = "idSerra" )
    @Mapping( target = "aziendaAgricolaEntity", ignore = true )
    @Mapping( target = "serraEntity", ignore = true )
    public abstract IrrigazionePianificatoreEntity modelToEntityOfIrrigazionePianificatore ( IrrigazionePianificatoreModel irrigazionePianificatoreModel );

    @Mapping( target = "sensoreEntity.idSensore", source = "idSensore" )
    @Mapping( target = "sensoreEntity", ignore = true )
    public abstract MisuraEntity modelToEntityOfMisura ( MisuraModel misuraModel );

    public abstract RuoloEntity modelToEntityOfRuolo ( RuoloModel ruoloModel );

    public abstract ExecutionTimeEntity modelToEntityOfExecutionTime ( ExecutionTimeModel executionTimeModel );

    @Mapping( target = "idUtente", ignore = true )
    public abstract void updateEntity ( UtenteModel newUtente, @MappingTarget UtenteEntity oldUtente );

}
