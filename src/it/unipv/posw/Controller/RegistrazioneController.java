package it.unipv.posw.Controller;

import it.unipv.posw.Exception.EmailEsistenteException;
import it.unipv.posw.Exception.EmptyFieldException;
import it.unipv.posw.Exception.WrongEmailFormatException;
import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Model.Service.RegistrazioneService;
import it.unipv.posw.View.AlertView;
import it.unipv.posw.View.RegistrazioneView;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class RegistrazioneController {
    private RegistrazioneView view;
    private RegistrazioneService rService;

    public RegistrazioneController(RegistrazioneView view) {
        this.view = view;
        this.rService = new RegistrazioneService();

        
        this.view.btnRegistrati.setOnAction(this::gestisciRegistrazione);
    }

    private void gestisciRegistrazione(ActionEvent e) {
        // Creazione oggetto modello con i dati della view
        Cliente c = new Cliente(
          
            view.txtNome.getText(),
            view.txtCognome.getText(),
            view.dateNascita.getValue(),
            view.txtEmail.getText(),
            view.txtPassword.getText()
        );

        // Chiamata al service 
        
        try {
        	rService.registraNuovoCliente(c);
        }catch (EmptyFieldException ex) {
        	AlertView.mostraErrore(ex.getMessage());
        }catch (WrongEmailFormatException ex) {
        	AlertView.mostraErrore(ex.getMessage());
        }catch (EmailEsistenteException ex) {
			AlertView.mostraErrore(ex.getMessage());
		}

       
    }
}
