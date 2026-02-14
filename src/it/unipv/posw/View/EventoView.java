package it.unipv.posw.View;

import java.time.format.DateTimeFormatter;


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
	ComboBox<String> comboBiglietti;
	Button btnAggiungi;
	Button btnCarrello;
	ComboBox<String> comboQuantita;

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
        Label lblData = new Label(evento.getDataora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

        infoBox.getChildren().addAll(lblNome, lblData);
        HBox.setHgrow(infoBox, Priority.ALWAYS);

        // Sezione selezione biglietto
        VBox actionBox = new VBox();
        actionBox.setSpacing(5);
        actionBox.setAlignment(Pos.CENTER_RIGHT);

        Label lblScelta = new Label("Tipologia biglietto:");
        
        comboBiglietti = new ComboBox<>();
        comboBiglietti.setItems(FXCollections.observableArrayList(
            "VIP", 
            "STANDARD", 
            "A VISIBILITÀ LIMITATA"
        ));
        comboBiglietti.getSelectionModel().select("STANDARD");

        btnCarrello = new Button("Vai al carrello");
        btnAggiungi = new Button("Aggiungi al carrello");
        Label lblQuantita = new Label("Quantità:");
        comboQuantita = new ComboBox<>();
        comboQuantita.setItems(FXCollections.observableArrayList("1", "2", "3", "4"));
        comboQuantita.getSelectionModel().select("1");
        
        actionBox.getChildren().addAll(lblScelta, comboBiglietti, lblQuantita, comboQuantita, btnAggiungi, btnCarrello);

        // Uniamo tutto
        this.getChildren().addAll(infoBox, actionBox);
    }

	public ComboBox<String> getComboBiglietti() {
		return comboBiglietti;
	}

	public Button getBtnAggiungi() {
		return btnAggiungi;
	}

	public Button getBtnCarrello() {
		return btnCarrello;
	}

	public ComboBox<String> getComboQuantita() {
		return comboQuantita;
	}
    
    
}