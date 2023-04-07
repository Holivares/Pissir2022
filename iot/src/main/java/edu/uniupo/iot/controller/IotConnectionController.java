package edu.uniupo.iot.controller;

import edu.uniupo.iot.model.SensoreModel;
import edu.uniupo.iot.service.IotConnectionService;
import jakarta.servlet.http.HttpSession;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/iot/v1")
public class IotConnectionController {
    private final IotConnectionService iotConnectionService;

    @Autowired
    public IotConnectionController ( IotConnectionService iotConnectionService ) {
        this.iotConnectionService = iotConnectionService;
    }

    @PostMapping(value = "/connection", produces = "application/json")
    public void getConnection ( HttpSession httpSession, @RequestBody List<SensoreModel> sensoreModelList ) throws MqttException {
        iotConnectionService.getConnection( httpSession, sensoreModelList );
    }
}
