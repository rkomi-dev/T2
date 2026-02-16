package it.unipv.posw.Controller;

import it.unipv.posw.Exception.CredenzialiErrateException;
import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Model.Sessione;
import it.unipv.posw.Model.Service.AutenticazioneService;
import it.unipv.posw.View.AlertView;
import it.unipv.posw.View.AutenticazioneView;
import javafx.event.ActionEvent;


public class AutenticazioneController {
	
	private AutenticazioneView view;
	private AutenticazioneService aService;

	public AutenticazioneController(AutenticazioneView view) {
	    this.view = view;
	    this.aService = new AutenticazioneService();
	    this.view.btnLogin.setOnAction(this::eseguiLogin);
	}

	private void eseguiLogin(ActionEvent e) {
	    
		try {
			Cliente loggato = aService.login(view.txtEmail.getText(), view.txtPassword.getText());
	    
	    
	    	Sessione.getInstance().svuotaSessione();
	    	Sessione.getInstance().setUtenteLoggato(loggato);
	    	NavigazioneController.getNcontroller().tornaAllaHome();
	    
		}catch (CredenzialiErrateException ex) {
			AlertView.mostraErrore(ex.getMessage());
		}
	}
}
