package it.unipv.posw.Controller;

import it.unipv.posw.Model.Cliente;
import it.unipv.posw.View.AutenticazioneView;
import it.unipv.posw.View.HomeView;
import it.unipv.posw.View.RegistrazioneView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class HomeController {
    private HomeView view;
    private RicercaController rController;

    public HomeController(HomeView view) {
        this.view = view;
        
        this.rController = new RicercaController(view.getRicercaView());
        // Gestione click sul menu Login
        view.itemLogin.setOnAction(e -> mostraLogin());

        // Gestione click sul menu Registrati
        view.itemRegistrati.setOnAction(e -> mostraRegistrazione());
    }
    
    
    private void mostraLogin() {
        AutenticazioneView loginView = new AutenticazioneView();
        // Inizializziamo il controller del login passandogli la home per poterla aggiornare dopo
        new AutenticazioneController(loginView, this); 
        view.setCenter(loginView);
    }

    private void mostraRegistrazione() {
        RegistrazioneView regView = new RegistrazioneView();
        // Qui andrebbe il controller della registrazione
        view.setCenter(regView);
    }

    // Metodo per aggiornare la UI dopo il login (UC4)
    public void aggiornaStatoLogin(Cliente c) {
        view.lblStatoUtente.setText("Loggato come: " + c.getNome() + " " + c.getCognome());
        view.lblStatoUtente.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        
        // Opzionale: pulire il centro o mostrare la dashboard
        view.setCenter(new Label("Accesso effettuato con successo!"));
    
    
    view.getRicercaView().getTxtRicerca().setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String testoCercato = view.getRicercaView().getTxtRicerca().getText();
            eseguiRicerca(testoCercato);
        }
    });
	}

	private void eseguiRicerca(String nomeEvento) {
		System.out.println("Ricerca definitiva per: " + nomeEvento);
		// Qui potresti cambiare il centro della HomeView con i risultati:
		// view.setCenter(new RisultatiRicercaView(nomeEvento));
	}
}
