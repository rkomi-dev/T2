package it.unipv.posw.Controller;

import it.unipv.posw.Model.Biglietto;
import it.unipv.posw.Model.Carrello;
import it.unipv.posw.View.CarrelloView;
import javafx.event.ActionEvent;


public class CarrelloController {
	
	private CarrelloView view;
    private Carrello carrelloModel;

    public CarrelloController(CarrelloView view) {
        this.view = view;
        this.carrelloModel = Carrello.getInstance();

        aggiornaDati();

        this.view.getBtnPaga().setOnAction(this::vaiAlPagamento);
        
    }

    public void aggiornaDati() {
        view.svuotaVista();
        
        for (Biglietto b : carrelloModel.getItems()) {
            String info = b.getTipo() + " : " + b.getPrezzo() + "€";
            view.aggiungiRigaBiglietto(info);
        }

        view.setTotale("Totale da pagare: " + carrelloModel.getTotale() + "€");
    }
    
    public void vaiAlPagamento(ActionEvent e) {
    	
    	NavigazioneController.getNcontroller().apriAcquisto();
    }

}
