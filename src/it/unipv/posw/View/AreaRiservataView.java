package it.unipv.posw.View;


import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.scene.layout.VBox;

public class AreaRiservataView extends VBox {
	
	private ListView<String> lista;
    private Label titolo;

    public AreaRiservataView() {
    	
    	this.getStylesheets().add(getClass().getResource("/css/registrazione.css").toExternalForm());
        this.getStyleClass().add("registrazione-pane");
        
        titolo = new Label("I Tuoi Biglietti Acquistati");
        lista = new ListView<>();

        this.getChildren().addAll(titolo, lista);
    }

    public ListView<String> getListaAcquisti() {
        return lista;
    }

}
