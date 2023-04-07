package edu.uniupo.pissir.service.implement;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.uniupo.pissir.entity.UtenteEntity;
import edu.uniupo.pissir.model.AziendaAgricolaModel;
import edu.uniupo.pissir.model.SensoreModel;
import edu.uniupo.pissir.model.SerraModel;
import edu.uniupo.pissir.service.AziendaAgricolaService;
import edu.uniupo.pissir.service.IotConnectionService;
import edu.uniupo.pissir.service.SensoreService;
import edu.uniupo.pissir.service.SerraService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class IotConnectionServiceImpl implements IotConnectionService {

    @Value( "${api.iot.connect.url}" )
    private String iotApiUrlConnection;
    private final AziendaAgricolaService aziendaAgricolaService;
    private final SerraService serraService;
    private final SensoreService sensoreService;
    private final HttpSession httpSession;

    @Autowired
    public IotConnectionServiceImpl ( AziendaAgricolaService aziendaAgricolaService, SerraService serraService, SensoreService sensoreService,
                                      HttpSession httpSession ) {
        this.aziendaAgricolaService = aziendaAgricolaService;
        this.serraService = serraService;
        this.sensoreService = sensoreService;
        this.httpSession = httpSession;
    }

    @Override
    public void getConnection ( UtenteEntity utenteEntity ) throws Exception {
        AziendaAgricolaModel aziendaAgricola = aziendaAgricolaService.findAziendaAgricolaByIdUser( httpSession, utenteEntity.getIdUtente() );
        List<SerraModel> serre = serraService.findSerraByIdAziendaAgricola( httpSession, aziendaAgricola.getIdAziendaAgricola() );
        List<SensoreModel> allSensore = new ArrayList<>();

        serre.forEach( serra -> {
            try {
                List<SensoreModel> sensore = sensoreService.findSensoreByIdSerra( httpSession, serra.getIdSerra() );
                allSensore.addAll( sensore );
            } catch( Exception e ) {
                throw new RuntimeException( e );
            }
        } );
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                                             .uri( new URI( iotApiUrlConnection ) )
                                             .POST( HttpRequest.BodyPublishers.ofString( new ObjectMapper().writeValueAsString( allSensore ) ) )
                                             .header( "Content-Type", "application/json" )
                                             .build();
        httpClient.send( httpRequest, HttpResponse.BodyHandlers.discarding() );
    }
}
