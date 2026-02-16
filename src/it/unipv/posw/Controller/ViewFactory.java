package it.unipv.posw.Controller;

import java.util.List;

import it.unipv.posw.Model.Evento;
import it.unipv.posw.View.AcquistoView;
import it.unipv.posw.View.AutenticazioneView;
import it.unipv.posw.View.CarrelloView;
import it.unipv.posw.View.EventiPerArtistaView;
import it.unipv.posw.View.EventoView;
import it.unipv.posw.View.QRView;
import it.unipv.posw.View.RegistrazioneView;
import it.unipv.posw.View.RicercaView;

public class ViewFactory {

    // 1. Istanza statica e privata (il cuore del Singleton)
    private static ViewFactory instance;

    // 2. Costruttore privato: impedisce a chiunque di fare "new ViewFactory()"
    private ViewFactory() {
    }

    // 3. Metodo pubblico per ottenere l'unica istanza esistente
    public static ViewFactory getInstance() {
        if (instance == null) {
            instance = new ViewFactory();
        }
        return instance;
    }

    // --- Metodi per la creazione delle viste ---

    public AutenticazioneView creaAutenticazioneView() {
        AutenticazioneView view = new AutenticazioneView();
        new AutenticazioneController(view);
        return view;
    }

    public RegistrazioneView creaRegistrazioneView() {
        RegistrazioneView view = new RegistrazioneView();
        new RegistrazioneController(view);
        return view;
    }
    
    public RicercaView creaRicercaView() {
        RicercaView view = new RicercaView();
        new RicercaController(view);
        return view;
    }
    
    public EventiPerArtistaView creaEventiPerArtistaView(String artista, List<?> e) {
    	EventiPerArtistaView view = new EventiPerArtistaView(artista, e);
    	new EventiPerArtistaController(view, e);
    	return view;
    }
    
    public EventoView creaEventoView(Evento e) {
    	EventoView view = new EventoView(e);
    	new EventoController(view, e);
    	return view;
    }
    
    public CarrelloView creaCarrelloView() {
    	CarrelloView view = new CarrelloView();
    	new CarrelloController(view);
    	return view;
    }
    
    public AcquistoView creaAcquistoView() {
    	AcquistoView view = new AcquistoView();
    	new AcquistoController(view);
    	return view;
    }
    
    public QRView creaQrView() {
    	QRView view = new QRView();
    	new QRController(view);
    	return view;
    }
}