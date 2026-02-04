package it.unipv.posw.Controller;

import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Service.AutenticazioneService;
import it.unipv.posw.Service.RegistrazioneService;
import it.unipv.posw.View.AutenticazioneView;

public class AutenticazioneController {
	
	private AutenticazioneView view;
	private HomeController homeController;
	private AutenticazioneService aService;

	public AutenticazioneController(AutenticazioneView view, HomeController homeController) {
	    this.view = view;
	    this.homeController = homeController;
	    this.aService = new AutenticazioneService();
	    this.view.btnLogin.setOnAction(e -> eseguiLogin());
	}

	private void eseguiLogin() {
	    // ... logica di controllo nel service ...
	    Cliente loggato = aService.login(view.txtEmail.getText(), view.txtPassword.getText());
	    
	    if (loggato != null) {
	        homeController.aggiornaStatoLogin(loggato);
	    } else {
	        // Alert errore
	    }
	}

}
