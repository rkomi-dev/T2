package it.unipv.posw.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AutenticazioneView extends VBox {
    // Rendiamo i componenti pubblici per permettere al Controller di leggerli
    public TextField txtEmail = new TextField();
    public PasswordField txtPassword = new PasswordField();
    public Button btnLogin = new Button("Accedi");
    public Button btnAnnulla = new Button("Annulla");

    public AutenticazioneView() {
        // 1. Configurazione del contenitore principale
        this.setSpacing(15);
        this.setPadding(new Insets(40));
        this.setAlignment(Pos.CENTER); // Centra gli elementi verticalmente
        this.getStyleClass().add("main-container"); // Classe definita nel common.css

        // 2. Titolo della sezione
        Label title = new Label("Area Riservata");
        title.getStyleClass().add("section-title");

        // 3. Configurazione campi di input
        txtEmail.setPromptText("Inserisci la tua email");
        txtPassword.setPromptText("Inserisci la password");
        
        // Applichiamo le classi CSS comuni per l'estetica
        txtEmail.getStyleClass().add("text-input");
        txtPassword.getStyleClass().add("text-input");
        
        // 4. Configurazione bottoni
        btnLogin.getStyleClass().add("button-primary");
        btnAnnulla.getStyleClass().add("button-secondary"); // Se vuoi uno stile diverso
        
        // Impostiamo una larghezza massima per non far allungare troppo i campi
        txtEmail.setMaxWidth(300);
        txtPassword.setMaxWidth(300);
        btnLogin.setMinWidth(120);

        // 5. Aggiunta dei componenti alla View
        this.getChildren().addAll(
            title, 
            new Label("Email:"), txtEmail, 
            new Label("Password:"), txtPassword, 
            btnLogin, 
            btnAnnulla
        );

        // 6. Caricamento dei file CSS
        // Carichiamo prima il comune, poi quello specifico (se esiste)
        try {
            this.getStylesheets().add(getClass().getResource("autenticazione.css").toExternalForm());
            //this.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        } catch (Exception e) {
            System.out.println("Nota: Alcuni file CSS non sono stati trovati, uso stile di default.");
        }
        this.getStyleClass().add("autenticazione-pane");
    }
}