package edu.uniupo.iot.service.implement;

import edu.uniupo.iot.model.SensoreModel;
import edu.uniupo.iot.model.TipoSensoreModel;
import edu.uniupo.iot.service.IotConnectionService;
import edu.uniupo.iot.shared.SensoreInfos;
import edu.uniupo.iot.task.PublishTask;
import edu.uniupo.iot.task.SubscribeTask;
import jakarta.servlet.http.HttpSession;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

@Service
public class IotConnectionServiceImpl implements IotConnectionService {
    private final PublishTask publishTask;
    private final SubscribeTask subscribeTask;

    public IotConnectionServiceImpl ( PublishTask publishTask, SubscribeTask subscribeTask ) {
        this.publishTask = publishTask;
        this.subscribeTask = subscribeTask;
    }

    @Override
    public void getConnection ( HttpSession httpSession, List<SensoreModel> sensoreModelList ) throws MqttException {
        Map<TipoSensoreModel, List<SensoreModel>> sensoreClassificationBySerra = sensoreModelList.stream().collect( groupingBy( SensoreModel::getTipo ));
        SensoreInfos.INSTANCE.setSensoreClassificationByType( sensoreClassificationBySerra );

        publishTask.runHumidityPublish();
        publishTask.runLightPublish();
        publishTask.runTemperaturePublish();

        subscribeTask.runTemperatureSubscribe();
        subscribeTask.runHumiditySubscribe();
        subscribeTask.runLightSubscribe();
    }
}
