package it.unipv.posw.View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class QRView extends VBox {
    
    private Label lblCodiceQR;

    public QRView() {
     
        this.getStylesheets().add(getClass().getResource("/css/registrazione.css").toExternalForm());
        this.getStylesheets().add(getClass().getResource("/css/qr.css").toExternalForm());
        this.getStyleClass().add("registrazione-pane");
        
        this.setSpacing(15); 
        this.setAlignment(Pos.CENTER);

        
        Label lblSuccesso = new Label("Acquisto andato a buon fine!");
        

        Pane qrPane = new Pane();
        qrPane.getStyleClass().add("qr");
        

        lblCodiceQR = new Label("Codice: ----");

        this.getChildren().addAll(lblSuccesso, qrPane, lblCodiceQR);
    }

    public void setCodiceTestuale(String codice) {
        this.lblCodiceQR.setText("Codice: " + codice);
    }
}


