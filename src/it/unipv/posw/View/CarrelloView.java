package it.unipv.posw.View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class CarrelloView extends VBox {
   
    private VBox listaProdotti; 
    private Label lblTotale;
    private Button btnPaga;

    public CarrelloView() {
        this.setSpacing(20);
        this.setPadding(new Insets(20));
        this.getStylesheets().add(getClass().getResource("registrazione.css").toExternalForm());
        this.getStyleClass().add("registrazione-pane");

        Label titolo = new Label("Il Tuo Carrello");
        
        ScrollPane scroll = new ScrollPane();
        listaProdotti = new VBox(10); 
        scroll.setContent(listaProdotti);
        scroll.setFitToWidth(true);
        scroll.setPrefHeight(300);

        lblTotale = new Label("Totale: 0.00€");
        lblTotale.setStyle("-fx-font-size: 18px;");
        
        btnPaga = new Button("Vai al pagamento");
        

        this.getChildren().addAll(titolo, scroll, lblTotale, btnPaga);
    }

    
    public void aggiungiRigaBiglietto(String testo) {
        Label riga = new Label(testo);
        riga.setStyle("-fx-padding: 10; -fx-border-color: #bdc3c7; -fx-border-width: 0 0 1 0;");
        listaProdotti.getChildren().add(riga);
    }

    public void svuotaVista() {
        listaProdotti.getChildren().clear();
    }

    public Button getBtnPaga() { return btnPaga; }
    public void setTotale(String totale) { lblTotale.setText(totale); }
}