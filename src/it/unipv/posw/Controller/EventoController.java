package it.unipv.posw.Controller;

import it.unipv.posw.Exception.IndisponibilitàException;
import it.unipv.posw.Exception.SuperamentoLimiteBigliettiException;
import it.unipv.posw.Model.Evento;
import it.unipv.posw.Model.Sessione;
import it.unipv.posw.Model.Service.CarrelloService;
import it.unipv.posw.View.AlertView;
import it.unipv.posw.View.EventoView;
import javafx.event.ActionEvent;


public class EventoController {
    private EventoView view;
    private Evento evento;
    private CarrelloService service;

    public EventoController(EventoView view, Evento evento) {
        this.view = view;
        this.evento = evento;
        this.service = new CarrelloService();
        
       
        this.view.getBtnAggiungi().setOnAction(this::gestisciAggiuntaCarrello);
        this.view.getBtnCarrello().setOnAction(this::vaiAlCarrello);
    }

    private void gestisciAggiuntaCarrello(ActionEvent e) {
        // Controllo Sessione: se non è loggato, reindirizzo
        if (!Sessione.getInstance().isLoggato()) {
             NavigazioneController.getNcontroller().apriLogin();
            return; 
        }


        String tipoScelto = view.getComboBiglietti().getValue();
        int quantita = Integer.parseInt(view.getComboQuantita().getValue());

        try {
        	service.aggiungiAlCarrello(evento.getId_evento(), tipoScelto, quantita);
        }catch (IndisponibilitàException ex) {
        	AlertView.mostraErrore(ex.getMessage());
        }catch (SuperamentoLimiteBigliettiException ex) {
        	AlertView.mostraErrore(ex.getMessage());
        }
        
    }

    private void vaiAlCarrello(ActionEvent e) {
        
        NavigazioneController.getNcontroller().apriCarrello();
    }

   
}