package edu.uniupo.iot.publisher;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightPublisher {
    private final IMqttClient mqttClient;
    private final static String TOPIC = "serra/light";
    private final static boolean RETAINED = true;
    private final static int QOS = 1;

    @Autowired
    public LightPublisher ( IMqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    public void publish(String misura, String idSensore) throws MqttException {
        String payload = String.join( "|", idSensore, misura );
        mqttClient.publish( TOPIC, payload.getBytes(), QOS, RETAINED);
    }
}
