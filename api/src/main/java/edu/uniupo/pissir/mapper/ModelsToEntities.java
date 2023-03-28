package edu.uniupo.pissir.mapper;

import edu.uniupo.pissir.entity.*;
import edu.uniupo.pissir.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper()
public abstract class ModelsToEntities {

    @Mapping( target = "idSerra", source = "serraEntity.idSerra" )
    public abstract AttuatoreModel entityToModelOfAttuatore ( AttuatoreEntity attuatoreEntity );

    @Mapping( target = "idAziendaAgricola", source = "aziendaAgricolaEntity.idAziendaAgricola" )
    public abstract SerraModel entityToModelOfSerra ( SerraEntity serraEntity );

    public List<SerraModel> entityToModelListOfSerra ( List<SerraEntity> serraEntities ) {
        List<SerraModel> serraModels = new ArrayList<>();
        serraEntities.forEach( serraEntity -> serraModels.add( entityToModelOfSerra( serraEntity ) ) );
        return serraModels;
    }

    public abstract StatoAttuatoreModel entityToModelOfAttuatore ( StatoAttuatoreEntity statoAttuatoreEntity );

    public List<AttuatoreModel> entityToModelListOfAttuatore ( List<AttuatoreEntity> attuatoreEntities ) {
        List<AttuatoreModel> attuatoreModels = new ArrayList<>();
        attuatoreEntities.forEach( attuatoreEntity -> attuatoreModels.add( entityToModelOfAttuatore( attuatoreEntity ) ) );
        return attuatoreModels;
    }

    public abstract TipoAttuatoreModel entityToModelOfTipoAttuatore ( TipoAttuatoreEntity tipoAttuatoreEntity );

    public abstract AttuatoreModeModel entityToModelOfAttuatoreMode ( AttuatoreModeEntity attuatoreModeEntity );

    public abstract AttuatoreStatoModel entityToModelOfAttuatoreStato ( AttuatoreStatoEntity attuatoreStatoEntity );

    public abstract UtenteModel entityToModelOfUtente ( UtenteEntity utenteEntity );

    @Mapping( target = "idUtente", source = "utenteEntity.idUtente" )
    public abstract AziendaAgricolaModel entityToModelOfAziendaAgricola ( AziendaAgricolaEntity aziendaAgricolaEntity );

    @Mapping( target = "idSerra", source = "serraEntity.idSerra" )
    public abstract SensoreModel entityToModelOfSensore ( SensoreEntity sensoreEntity );

    public List<SensoreModel> entityToModelListOfSensore ( List<SensoreEntity> sensoreEntities ) {
        List<SensoreModel> sensoreModels = new ArrayList<>();
        sensoreEntities.forEach( sensoreEntity -> sensoreModels.add( entityToModelOfSensore( sensoreEntity ) ) );
        return sensoreModels;
    }

    @Mapping( target = "idAziendaAgricola", source = "aziendaAgricolaEntity.idAziendaAgricola" )
    @Mapping( target = "idSerra", source = "serraEntity.idSerra" )
    public abstract IrrigazionePianificatoreModel entityToModelOfIrrigazionePianificatore ( IrrigazionePianificatoreEntity irrigazionePianificatoreEntity );

    public List<IrrigazionePianificatoreModel> entityToModelListOfIrrigazionePianificatore (
            List<IrrigazionePianificatoreEntity> irrigazionePianificatoreEntities
                                                                                           ) {
        List<IrrigazionePianificatoreModel> irrigazionePianificatoreModels = new ArrayList<>();
        irrigazionePianificatoreEntities.forEach( irrigazionePianificatoreEntity -> irrigazionePianificatoreModels.add( entityToModelOfIrrigazionePianificatore( irrigazionePianificatoreEntity ) ) );
        return irrigazionePianificatoreModels;
    }

    @Mapping( target = "idSensore", source = "sensoreEntity.idSensore" )
    public abstract MisuraModel entityToModelOfMisura ( MisuraEntity misuraEntity );

    public List<MisuraModel> entityToModelListOfMisura ( List<MisuraEntity> misuraEntities ) {
        List<MisuraModel> misuraModels = new ArrayList<>();
        misuraEntities.forEach( misuraEntity -> misuraModels.add( entityToModelOfMisura( misuraEntity ) ) );
        return misuraModels;
    }

    public abstract RuoloModel entityToModelOfRuolo ( RuoloEntity ruoloEntity );

    public abstract ExecutionTimeModel entityToModelOfExecutionTime ( ExecutionTimeEntity executionTimeEntity );

    @Mapping( target = "serraEntity.idSerra", source = "idSerra" )
    @Mapping( target = "serraEntity", ignore = true )
    public abstract AttuatoreEntity modelToEntityOfAttuatore ( AttuatoreModel attuatoreModel );

    public List<AttuatoreEntity> modelToEntityListOfAttuatore ( List<AttuatoreModel> attuatoreModels ) {
        List<AttuatoreEntity> attuatoreEntities = new ArrayList<>();
        attuatoreModels.forEach( attuatoreModel -> attuatoreEntities.add( modelToEntityOfAttuatore( attuatoreModel ) ) );
        return attuatoreEntities;
    }

    @Mapping( target = "aziendaAgricolaEntity.idAziendaAgricola", source = "idAziendaAgricola" )
    @Mapping( target = "aziendaAgricolaEntity", ignore = true )
    public abstract SerraEntity modelToEntityOfSerra ( SerraModel serraModel );

    public List<SerraEntity> modelToEntityListOfSerra ( List<SerraModel> serraModels ) {
        List<SerraEntity> serraEntities = new ArrayList<>();
        serraModels.forEach( serraModel -> serraEntities.add( modelToEntityOfSerra( serraModel ) ) );
        return serraEntities;
    }

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

    public List<SensoreEntity> modelToEntityListOfSensore ( List<SensoreModel> sensoreEntities ) {
        List<SensoreEntity> sensoreModels = new ArrayList<>();
        sensoreEntities.forEach( sensoreModel -> sensoreModels.add( modelToEntityOfSensore( sensoreModel ) ) );
        return sensoreModels;
    }

    @Mapping( target = "aziendaAgricolaEntity.idAziendaAgricola", source = "idAziendaAgricola" )
    @Mapping( target = "serraEntity.idSerra", source = "idSerra" )
    @Mapping( target = "aziendaAgricolaEntity", ignore = true )
    @Mapping( target = "serraEntity", ignore = true )
    public abstract IrrigazionePianificatoreEntity modelToEntityOfIrrigazionePianificatore ( IrrigazionePianificatoreModel irrigazionePianificatoreModel );

    public List<IrrigazionePianificatoreEntity> modelToEntityListOfIrrigazionePianificatore ( List<IrrigazionePianificatoreModel> irrigazionePianificatoreModels
                                                                                            ) {
        List<IrrigazionePianificatoreEntity> irrigazionePianificatoreEntities = new ArrayList<>();
        irrigazionePianificatoreModels.forEach( irrigazionePianificatoreModel -> irrigazionePianificatoreEntities.add( modelToEntityOfIrrigazionePianificatore( irrigazionePianificatoreModel ) ) );
        return irrigazionePianificatoreEntities;
    }

    @Mapping( target = "sensoreEntity.idSensore", source = "idSensore" )
    @Mapping( target = "sensoreEntity", ignore = true )
    public abstract MisuraEntity modelToEntityOfMisura ( MisuraModel misuraModel );

    public List<MisuraEntity> modelToEntityListOfMisura ( List<MisuraModel> misuraModels ) {
        List<MisuraEntity> misuraEntities = new ArrayList<>();
        misuraModels.forEach( misuraEntity -> misuraEntities.add( modelToEntityOfMisura( misuraEntity ) ) );
        return misuraEntities;
    }

    public abstract RuoloEntity modelToEntityOfRuolo ( RuoloModel ruoloModel );

    public abstract ExecutionTimeEntity modelToEntityOfExecutionTime ( ExecutionTimeModel executionTimeModel );

    @Mapping( target = "idUtente", ignore = true )
    public abstract void updateUtenteEntity ( UtenteModel newUtente, @MappingTarget UtenteEntity oldUtente );

    @Mapping( target = "idAziendaAgricola", ignore = true )
    @Mapping( target = "utenteEntity.idUtente", source = "idUtente" )
    @Mapping( target = "utenteEntity", ignore = true )
    public abstract void updateAziendaAgricolaEntity ( AziendaAgricolaModel newAziendaAgricolaModel,
                                                       @MappingTarget AziendaAgricolaEntity oldAziendaAgricolaEntity
                                                     );

    @Mapping( target = "idSerra", ignore = true )
    @Mapping( target = "aziendaAgricolaEntity.idAziendaAgricola", source = "idAziendaAgricola" )
    @Mapping( target = "aziendaAgricolaEntity", ignore = true )
    public abstract void updateSerraEntity ( SerraModel newSerra, @MappingTarget SerraEntity oldSerra );

    @Mapping( target = "aziendaAgricolaEntity.idAziendaAgricola", source = "idAziendaAgricola" )
    @Mapping( target = "serraEntity.idSerra", source = "idSerra" )
    @Mapping( target = "aziendaAgricolaEntity", ignore = true )
    @Mapping( target = "serraEntity", ignore = true )
    public abstract void updateIrrigazionePianificatore ( IrrigazionePianificatoreModel newIrrigazionePianificatore,
                                                          @MappingTarget IrrigazionePianificatoreEntity oldIrrigazionePianificatore
                                                        );

}
