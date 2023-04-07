package edu.uniupo.iot.service.implement;

import edu.uniupo.iot.model.MisuraRequestModel;
import edu.uniupo.iot.model.MisuraResponseModel;
import edu.uniupo.iot.service.IotRegisteredMisuraService;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.util.UUID;

@Service
public class IotRegisteredMisuraServiceImpl implements IotRegisteredMisuraService {

    @Value( "${api.misura.create.url}" )
    private String sensoriUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public IotRegisteredMisuraServiceImpl ( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void registeredMisura ( MqttMessage message ) {
        StringTokenizer stringTokenizer = new StringTokenizer( new String( message.getPayload() ), "|", false );
        String idSensore = stringTokenizer.nextToken();
        String misura = stringTokenizer.nextToken();
        restTemplate.postForEntity( sensoriUrl, new MisuraRequestModel( UUID.fromString(idSensore), new BigDecimal( misura ) ), MisuraResponseModel.class );
    }
}
