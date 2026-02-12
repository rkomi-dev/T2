package it.unipv.posw.Controller;

import java.util.List;

import it.unipv.posw.Model.Evento;
import it.unipv.posw.View.HomeView;

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

    public void apriEventiPerArtista(String artista, List <?> e) {
    	homeView.setCenter(ViewFactory.getInstance().creaEventiPerArtistaView(artista, e));
    }
    
    public void apriEvento(Evento e) {
    	homeView.setCenter(ViewFactory.getInstance().creaEventoView(e));
    }
}


