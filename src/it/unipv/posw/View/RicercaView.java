package it.unipv.posw.View;

import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;



public class RicercaView extends HBox {
    private TextField txtRicerca;
    private ComboBox<String> comboTipoRicerca;
    

    public RicercaView() {
    	this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        
        comboTipoRicerca = new ComboBox<>();
        comboTipoRicerca.getItems().addAll("per: Evento", "per: Artista");
        comboTipoRicerca.setValue("per: Evento"); // Valore predefinito
        
        
        txtRicerca = new TextField();
        txtRicerca.setPromptText("🔍 Cerca un evento...");
        txtRicerca.setPrefWidth(300);
        
        // Applichiamo la classe CSS per renderlo tondo
        txtRicerca.getStyleClass().add("search-field");
        
        this.getChildren().addAll(comboTipoRicerca, txtRicerca);
    }

    public TextField getTxtRicerca() {
        return txtRicerca;
    }
    
    public ComboBox<String> getComboTipoRicerca() {
        return comboTipoRicerca;
    }
    
    public String getTipoSelezionato() {
        return comboTipoRicerca.getValue();
    }
}
