package it.unipv.posw.View;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertView {
	
	public static void mostraErrore(String messaggio) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERRORE");
        alert.setHeaderText(null);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }

}
