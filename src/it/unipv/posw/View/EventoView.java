package it.unipv.posw.View;

import it.unipv.posw.Model.Evento;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class EventoView extends HBox {

    public EventoView(Evento evento) {
        // Layout principale
        this.setPadding(new Insets(10));
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER_LEFT);
        this.getStylesheets().add(getClass().getResource("registrazione.css").toExternalForm());
        this.getStyleClass().add("registrazione-pane");
        // Sezione dati (Nome, Sede, Data)
        VBox infoBox = new VBox();
        infoBox.setSpacing(5);
        
        Label lblNome = new Label(evento.getNome());
        Label lblData = new Label(evento.getDataora().toString());

        infoBox.getChildren().addAll(lblNome, lblData);
        HBox.setHgrow(infoBox, Priority.ALWAYS);

        // Sezione selezione biglietto
        VBox actionBox = new VBox();
        actionBox.setSpacing(5);
        actionBox.setAlignment(Pos.CENTER_RIGHT);

        Label lblScelta = new Label("Tipologia biglietto:");
        
        ComboBox<String> comboBiglietti = new ComboBox<>();
        comboBiglietti.setItems(FXCollections.observableArrayList(
            "VIP", 
            "STANDARD", 
            "A VISIBILITÀ LIMITATA"
        ));
        comboBiglietti.getSelectionModel().select("STANDARD");

        Button btnSeleziona = new Button("Seleziona");

        actionBox.getChildren().addAll(lblScelta, comboBiglietti, btnSeleziona);

        // Uniamo tutto
        this.getChildren().addAll(infoBox, actionBox);
    }
}