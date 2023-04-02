package edu.uniupo.pissir.controller;

import edu.uniupo.pissir.model.DeleteResponseModel;
import edu.uniupo.pissir.model.IrrigazionePianificatoreModel;
import edu.uniupo.pissir.service.IrrigazionePianificatoreService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( "v1/piani" )
public class IrrigazionePianificatoreController {

    private final IrrigazionePianificatoreService irrigazionePianificatoreService;
    private final Logger logger = LoggerFactory.getLogger( IrrigazionePianificatoreController.class );

    @Autowired
    public IrrigazionePianificatoreController ( IrrigazionePianificatoreService irrigazionePianificatoreService ) {
        this.irrigazionePianificatoreService = irrigazionePianificatoreService;
    }

    @PostMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.CREATED )
    public IrrigazionePianificatoreModel createIrrigazionePianificatore ( HttpSession session,
                                                                          @RequestBody IrrigazionePianificatoreModel irrigazionePianificatoreModel
                                                                        ) throws Exception {
        logger.info( "i'm in the controller to create an pianificatore ..." );
        return irrigazionePianificatoreService.createIrrigazionePianificatore( session, irrigazionePianificatoreModel );
    }

    @PutMapping( produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public IrrigazionePianificatoreModel updateIrrigazionePianificatore ( HttpSession session,
                                                                          @RequestBody IrrigazionePianificatoreModel irrigazionePianificatoreModel
                                                                        ) throws Exception {
        logger.info( "i'm in the controller to update an pianificatore ..." );
        return irrigazionePianificatoreService.updateIrrigazionePianificatore( session, irrigazionePianificatoreModel );
    }

    @DeleteMapping( value = "/{idIrrigazionePianificatore}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.OK )
    public DeleteResponseModel deleteIrrigazionePianificatore ( HttpSession session, @PathVariable UUID idIrrigazionePianificatore ) throws Exception {
        logger.info( "i'm in controller to delete an pianificatore ..." );
        return irrigazionePianificatoreService.deleteIrrigazionePianificatoreById( session, idIrrigazionePianificatore );
    }

    @GetMapping( value = "/{idAziendaAgricola}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public List<IrrigazionePianificatoreModel> findIrrigazionePianificatoreByIdAziendaAgricola ( HttpSession session,
                                                                                                 @PathVariable UUID idAziendaAgricola ) throws Exception {
        logger.info( "i'm in the controller to find an pianificatore by AziendaAgricola id ..." );
        return irrigazionePianificatoreService.findIrrigazionePianificatoreByIdAziendaAgricola( session, idAziendaAgricola );
    }

    @GetMapping( value = "/{idSerra}", produces = "application/json" )
    @ResponseStatus( value = HttpStatus.FOUND )
    public List<IrrigazionePianificatoreModel> findIrrigazionePianificatoreByIdSerra ( HttpSession session, @PathVariable UUID idSerra ) throws Exception {
        logger.info( "i'm in controller to find an pianificatore by Serra id ..." );
        return irrigazionePianificatoreService.findIrrigazionePianificatoreByIdserra( session, idSerra );
    }

}
