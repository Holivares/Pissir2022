package edu.uniupo.iot.shared;

import edu.uniupo.iot.model.SensoreModel;
import edu.uniupo.iot.model.TipoSensoreModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
public enum SensoreInfos {
    INSTANCE;
    @Setter
    private Map<TipoSensoreModel, List<SensoreModel>> sensoreClassificationByType;
}
