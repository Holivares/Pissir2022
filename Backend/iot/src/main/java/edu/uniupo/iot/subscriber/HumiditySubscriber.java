package edu.uniupo.iot.subscriber;

import edu.uniupo.iot.service.IotRegisteredMisuraService;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumiditySubscriber {
    private final IMqttClient mqttClient;
    private final static String TOPIC = "serra/humidity";
    private final IotRegisteredMisuraService iotRegisteredMisuraService;

    @Autowired
    public HumiditySubscriber ( IMqttClient mqttClient, IotRegisteredMisuraService iotRegisteredMisuraService ) {
        this.mqttClient = mqttClient;
        this.iotRegisteredMisuraService = iotRegisteredMisuraService;
    }

    public void subscribe () throws MqttException {
        mqttClient.subscribeWithResponse( TOPIC, ( topic, message ) -> {
            iotRegisteredMisuraService.registeredMisura( message );
            System.out.println( message.getId() + "->" + new String( message.getPayload() ) );
        } );
    }
}
