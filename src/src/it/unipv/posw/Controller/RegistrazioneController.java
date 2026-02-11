package it.unipv.posw.Controller;

import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Model.Service.RegistrazioneService;
import it.unipv.posw.View.RegistrazioneView;
import javafx.scene.control.Alert;

public class RegistrazioneController {
    private RegistrazioneView view;
    private RegistrazioneService rService;

    public RegistrazioneController(RegistrazioneView view) {
        this.view = view;
        this.rService = new RegistrazioneService();

        // Colleghiamo l'evento al bottone programmaticamente
        this.view.btnRegistrati.setOnAction(e -> gestisciRegistrazione());
    }

    private void gestisciRegistrazione() {
        // Creazione oggetto modello con i dati della view
        Cliente c = new Cliente(
          
            view.txtNome.getText(),
            view.txtCognome.getText(),
            view.dateNascita.getValue(),
            view.txtEmail.getText(),
            view.txtPassword.getText()
        );

        // Chiamata al service (Logica di Business)
        String esito = rService.registraNuovoCliente(c);

        // Feedback all'utente tramite Alert (RNF8 - Usabilità)
        Alert alert = new Alert(esito.equals("OK") ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(esito.equals("OK") ? "Registrazione completata!" : esito);
        alert.showAndWait();
    }
}
