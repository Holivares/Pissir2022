package edu.uniupo.iot.task;

import edu.uniupo.iot.model.SensoreModel;
import edu.uniupo.iot.model.TipoSensoreModel;
import edu.uniupo.iot.publisher.HumidityPublisher;
import edu.uniupo.iot.publisher.LightPublisher;
import edu.uniupo.iot.publisher.TemperaturePublisher;
import edu.uniupo.iot.shared.SensoreInfos;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class PublishTask {
    private final LightPublisher lightPublisher;
    private final TemperaturePublisher temperaturePublisher;
    private final HumidityPublisher humidityPublisher;
    private final Logger logger = LoggerFactory.getLogger( PublishTask.class );

    @Autowired
    public PublishTask ( LightPublisher lightPublisher, TemperaturePublisher temperaturePublisher, HumidityPublisher humidityPublisher ) {
        this.lightPublisher = lightPublisher;
        this.temperaturePublisher = temperaturePublisher;
        this.humidityPublisher = humidityPublisher;
    }

    @Scheduled( cron = "3 * * * * ?" )
    public void runLightPublish() {
        logger.info( "publisher publish light measure at time " + LocalDateTime.now() );
        Map<UUID, Integer> allReadyPublish = new HashMap<>();
        List<SensoreModel> luceSensore = SensoreInfos.INSTANCE.getSensoreClassificationByType().values().stream()
                                                          .flatMap( entryByType -> entryByType.stream()
                                                                                              .filter( sensoreModel -> sensoreModel.getTipo() == TipoSensoreModel.LUCE ) )
                                                          .toList();
        publishEvent( allReadyPublish, luceSensore, "light" );
    }

    @Scheduled( cron = "2 * * * * ?" )
    public void runTemperaturePublish () {
        logger.info( "publisher publish temperature measure at time " + LocalDateTime.now() );
        Map<UUID, Integer> allReadyPublish = new HashMap<>();
        List<SensoreModel> temperaturaSensore = SensoreInfos.INSTANCE.getSensoreClassificationByType().values().stream()
                                                          .flatMap( entryByType -> entryByType.stream()
                                                                                              .filter( sensoreModel -> sensoreModel.getTipo() == TipoSensoreModel.TEMPERATURA ) )
                                                          .toList();
        publishEvent(allReadyPublish, temperaturaSensore, "temperature");
    }

    @Scheduled( cron = "1 * * * * ?" )
    public void runHumidityPublish () {
        logger.info( "publisher publish humidity measure at time " + LocalDateTime.now() );
        Map<UUID, Integer> allReadyPublish = new HashMap<>();
        List<SensoreModel> umiditaSensore = SensoreInfos.INSTANCE.getSensoreClassificationByType().values().stream()
                                                          .flatMap( entryByType -> entryByType.stream()
                                                                                              .filter( sensoreModel -> sensoreModel.getTipo() == TipoSensoreModel.UMIDITA ) )
                                                          .toList();
        publishEvent( allReadyPublish, umiditaSensore, "humidity" );
    }

    private void publishEvent ( Map<UUID, Integer> allReadyPublish, List<SensoreModel> sensoreModels, String type ) {
        switch( type ) {
            case "humidity" -> sensoreModels.forEach( sensore -> {
                try {
                    if( allReadyPublish.containsKey( sensore.getIdSensore() ) ) {
                        if( allReadyPublish.get( sensore.getIdSensore() )<=4 ) {
                            humidityPublisher.publish( String.valueOf( new Random().nextInt( 100 ) ), sensore.getIdSensore().toString() );
                            allReadyPublish.put( sensore.getIdSensore(), ( allReadyPublish.get( sensore.getIdSensore() ) + 1 ) );
                        }
                    } else {
                        humidityPublisher.publish( String.valueOf( new Random().nextInt( 100 ) ), sensore.getIdSensore().toString() );
                        allReadyPublish.put( sensore.getIdSensore(), 1 );
                    }
                } catch( MqttException e ) {
                    throw new RuntimeException( e );
                }
            } );
            case "temperature" -> sensoreModels.forEach( sensore -> {
                try {
                    if( allReadyPublish.containsKey( sensore.getIdSensore() ) ) {
                        if( allReadyPublish.get( sensore.getIdSensore() )<=4 ) {
                            temperaturePublisher.publish( String.valueOf( new Random().nextInt( 100 ) ), sensore.getIdSensore().toString() );
                            allReadyPublish.put( sensore.getIdSensore(), ( allReadyPublish.get( sensore.getIdSensore() ) + 1 ) );
                        }
                    } else {
                        temperaturePublisher.publish( String.valueOf( new Random().nextInt( 100 ) ), sensore.getIdSensore().toString() );
                        allReadyPublish.put( sensore.getIdSensore(), 1 );
                    }
                } catch( MqttException e ) {
                    throw new RuntimeException( e );
                }
            } );
            case "light" -> sensoreModels.forEach( sensore -> {
                try {
                    if( allReadyPublish.containsKey( sensore.getIdSensore() ) ) {
                        if( allReadyPublish.get( sensore.getIdSensore() )<=4 ) {
                            lightPublisher.publish( String.valueOf( new Random().nextInt( 100 ) ), sensore.getIdSensore().toString() );
                            allReadyPublish.put( sensore.getIdSensore(), ( allReadyPublish.get( sensore.getIdSensore() ) + 1 ) );
                        }
                    } else {
                        lightPublisher.publish( String.valueOf( new Random().nextInt( 100 ) ), sensore.getIdSensore().toString() );
                        allReadyPublish.put( sensore.getIdSensore(), 1 );
                    }
                } catch( MqttException e ) {
                    throw new RuntimeException( e );
                }
            } );
        }
    }

}
