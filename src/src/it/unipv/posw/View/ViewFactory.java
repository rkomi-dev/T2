package it.unipv.posw.View;

import it.unipv.posw.Controller.AutenticazioneController;
import it.unipv.posw.Controller.RegistrazioneController;
import it.unipv.posw.Controller.RicercaController;

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
}