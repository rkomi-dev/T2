package it.unipv.posw.View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class AcquistoView extends VBox {
    private Label lblTotale;
    private Button btnConfermaAcquisto;
    private ListView<String> elencoBiglietti;
    private RadioButton rbPaypal;
    private RadioButton rbMastercard;
    private ToggleGroup gruppoPagamento;

    public AcquistoView() {
        // Spaziatura tra gli elementi
        this.setSpacing(10);
        this.getStylesheets().add(getClass().getResource("/css/registrazione.css").toExternalForm());
        this.getStyleClass().add("registrazione-pane");
        // 1. Riepilogo
        this.getChildren().add(new Label("Riepilogo Ordine:"));
        elencoBiglietti = new ListView<>();
        //this.getChildren().add(elencoBiglietti);

        lblTotale = new Label("Totale da pagare: € 0.00");
        this.getChildren().add(lblTotale);

        // 2. Selezione Pagamento
        this.getChildren().add(new Label("Seleziona metodo di pagamento:"));
        
        gruppoPagamento = new ToggleGroup();

        rbPaypal = new RadioButton("PayPal");
        rbPaypal.setToggleGroup(gruppoPagamento);
        // Possiamo pre-selezionarne uno per evitare controlli nulli
        rbPaypal.setSelected(true); 

        rbMastercard = new RadioButton("Mastercard");
        rbMastercard.setToggleGroup(gruppoPagamento);

        this.getChildren().addAll(rbPaypal, rbMastercard);

        // 3. Azione finale
        btnConfermaAcquisto = new Button("Acquista ora");
        this.getChildren().add(btnConfermaAcquisto);
    }

    // Getter per permettere al Controller di leggere i dati e i click
    public Button getBtnConfermaAcquisto() { return btnConfermaAcquisto; }
    public ToggleGroup getGruppoPagamento() { return gruppoPagamento; }
    public RadioButton getRbPaypal() { return rbPaypal; }
    public RadioButton getRbMastercard() { return rbMastercard; }
    
    public Label getLblTotale() {
		return lblTotale;
	}

	public void setTotale(double totale) {
        lblTotale.setText("Totale da pagare: € " + totale);
    }

    public void aggiungiElemento(String info) {
        elencoBiglietti.getItems().add(info);
    }
}
