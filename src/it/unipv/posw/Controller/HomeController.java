package it.unipv.posw.Controller;

import it.unipv.posw.Model.Sessione;
import it.unipv.posw.View.HomeView;
import javafx.event.ActionEvent;

public class HomeController {
    private HomeView view;

    public HomeController(HomeView view) {
        this.view = view;
        
        // Diciamo al navigatore qual è la home su cui lavorare
        NavigazioneController.getNcontroller().setHomeView(this.view);
        
        view.itemHome.setOnAction(this::handleHome);
        view.itemLogin.setOnAction(this::handleLogin);
        view.itemRegistrati.setOnAction(this::handleRegistrazione);
        view.itemAreaRis.setOnAction(this::handleAreaRiservata);
        
    }
    
    public void handleHome(ActionEvent e) {
    	NavigazioneController.getNcontroller().tornaAllaHome();
    }
    
    public void handleLogin(ActionEvent e) {
    	NavigazioneController.getNcontroller().apriLogin();
    }
    
    public void handleRegistrazione(ActionEvent e) {
    	NavigazioneController.getNcontroller().apriRegistrazione();
    }
    
    public void handleAreaRiservata(ActionEvent e) {
    	
    	if(!Sessione.getInstance().isLoggato()) {
    		NavigazioneController.getNcontroller().apriLogin();
    		return;
    	}
    	NavigazioneController.getNcontroller().apriAreaRiservata();
    }
}