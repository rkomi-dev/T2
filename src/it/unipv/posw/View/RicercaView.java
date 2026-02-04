package it.unipv.posw.View;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;



public class RicercaView extends HBox {
    private TextField txtRicerca;

    public RicercaView() {
        this.setAlignment(Pos.CENTER);
        
        txtRicerca = new TextField();
        txtRicerca.setPromptText("🔍 Cerca un evento...");
        txtRicerca.setPrefWidth(300);
        
        // Applichiamo la classe CSS per renderlo tondo
        txtRicerca.getStyleClass().add("search-field");
        
        this.getChildren().add(txtRicerca);
    }

    public TextField getTxtRicerca() {
        return txtRicerca;
    }
}
