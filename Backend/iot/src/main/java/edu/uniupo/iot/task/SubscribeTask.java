package edu.uniupo.iot.task;

import edu.uniupo.iot.subscriber.HumiditySubscriber;
import edu.uniupo.iot.subscriber.LightSubscriber;
import edu.uniupo.iot.subscriber.TemperatureSubscriber;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SubscribeTask {
    private final LightSubscriber lightSubscriber;
    private final TemperatureSubscriber temperatureSubscriber;
    private final HumiditySubscriber humiditySubscriber;
    private final Logger logger = LoggerFactory.getLogger( SubscribeTask.class );

    @Autowired
    public SubscribeTask ( LightSubscriber lightSubscriber, TemperatureSubscriber temperatureSubscriber, HumiditySubscriber humiditySubscriber ) {
        this.lightSubscriber = lightSubscriber;
        this.temperatureSubscriber = temperatureSubscriber;
        this.humiditySubscriber = humiditySubscriber;
    }

    @Scheduled( cron = "2 * * * * ?" )
    public void runLightSubscribe () throws MqttException {
        logger.info( "Get to subscribe to light publisher at time:" + LocalDateTime.now() );
        lightSubscriber.subscribe();
    }

    @Scheduled( cron = "1 * * * * ?" )
    public void runTemperatureSubscribe () throws MqttException {
        logger.info( "Get to subscribe to temperature publisher at time:" + LocalDateTime.now() );
        temperatureSubscriber.subscribe();
    }

    @Scheduled( cron = "3 * * * * ?" )
    public void runHumiditySubscribe () throws MqttException {
        logger.info( "Get to subscribe to humidity publisher at time:" + LocalDateTime.now() );
        humiditySubscriber.subscribe();
    }
}
