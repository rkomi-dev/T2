package it.unipv.posw.View;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class RegistrazioneView extends VBox {
    // Rendiamo i campi accessibili al controller
    public TextField txtNome = new TextField();
    public TextField txtCognome = new TextField();
    public TextField txtEmail = new TextField();
    public PasswordField txtPassword = new PasswordField();
    public DatePicker dateNascita = new DatePicker();
    public Button btnRegistrati = new Button("Registrati");

    public RegistrazioneView() {
    	
    	this.getStylesheets().add(getClass().getResource("registrazione.css").toExternalForm());
        this.getStyleClass().add("registrazione-pane");
        this.setPadding(new Insets(20));
        this.setSpacing(10);

        // Aggiungiamo etichette e campi
        this.getChildren().addAll(
            new Label("Nome:"), txtNome,
            new Label("Cognome:"), txtCognome,
            new Label("Email:"), txtEmail,
            new Label("Password:"), txtPassword,
            new Label("Data di Nascita:"), dateNascita,
            btnRegistrati
        );
        
        btnRegistrati.getStyleClass().add("button-primary");
    }
}
