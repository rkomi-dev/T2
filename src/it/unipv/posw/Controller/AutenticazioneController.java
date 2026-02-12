package it.unipv.posw.Controller;

import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Model.Service.AutenticazioneService;
import it.unipv.posw.View.AutenticazioneView;
import javafx.event.ActionEvent;


public class AutenticazioneController {
	
	private AutenticazioneView view;
	//private HomeController homeController;
	private AutenticazioneService aService;

	public AutenticazioneController(AutenticazioneView view) {
	    this.view = view;
	    //this.homeController = homeController;
	    this.aService = new AutenticazioneService();
	    this.view.btnLogin.setOnAction(this::eseguiLogin);
	}

	private void eseguiLogin(ActionEvent e) {
	    // ... logica di controllo nel service ...
	    Cliente loggato = aService.login(view.txtEmail.getText(), view.txtPassword.getText());
	    
	}

}
