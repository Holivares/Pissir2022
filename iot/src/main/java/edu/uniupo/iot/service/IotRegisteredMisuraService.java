package edu.uniupo.iot.service;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface IotRegisteredMisuraService {

    void registeredMisura( MqttMessage message ) throws Exception;
}
