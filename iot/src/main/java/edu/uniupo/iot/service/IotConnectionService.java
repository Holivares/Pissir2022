package edu.uniupo.iot.service;

import edu.uniupo.iot.model.SensoreModel;
import jakarta.servlet.http.HttpSession;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.List;

public interface IotConnectionService {
    void getConnection ( HttpSession httpSession, List<SensoreModel> sensoreModelList ) throws MqttException;
}
