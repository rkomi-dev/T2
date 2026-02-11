package it.unipv.posw.Controller;

import it.unipv.posw.View.HomeView;
import it.unipv.posw.View.ViewFactory;

public class NavigazioneController {
	
    private static NavigazioneController ncontroller;
    private HomeView homeView;

    private NavigazioneController() {}

    public static NavigazioneController getNcontroller() {
        if (ncontroller == null) {
            ncontroller = new NavigazioneController();
        }
        return ncontroller;
    }

    public void setHomeView(HomeView homeView) {
        this.homeView = homeView;
    }

    public void apriLogin() {
        homeView.setCenter(ViewFactory.getInstance().creaAutenticazioneView());
    }

    public void apriRegistrazione() {
        homeView.setCenter(ViewFactory.getInstance().creaRegistrazioneView());
    }
    
    public void tornaAllaHome() {
        homeView.setCenter(null);
    }

  
}


