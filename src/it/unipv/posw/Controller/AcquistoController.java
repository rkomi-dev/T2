package it.unipv.posw.Controller;

import it.unipv.posw.Model.Carrello;
import it.unipv.posw.Model.Sessione;
import it.unipv.posw.Model.Service.AcquistoService;
import it.unipv.posw.Model.Service.Payment.IMastercard;
import it.unipv.posw.Model.Service.Payment.IPayPal;
import it.unipv.posw.Model.Service.Payment.MasterCard;
import it.unipv.posw.Model.Service.Payment.PagamentoFactory;
import it.unipv.posw.Model.Service.Payment.PayPal;
import it.unipv.posw.View.AcquistoView;
import javafx.event.ActionEvent;

public class AcquistoController {
	
	private AcquistoView view;
	private AcquistoService service;
	/**
	 * @param view
	 */
	public AcquistoController(AcquistoView view) {
		super();
		this.view = view;
		this.service = new AcquistoService();
		
		Riepilogo();
		view.getBtnConfermaAcquisto().setOnAction(this::Acquista);
	}
	
	public void Acquista(ActionEvent e) {
		
		String tipo = view.getRbPaypal().isSelected() ? "PayPal" : "Mastercard";
		
		try {
			if(tipo.equals("PayPal")) {
				IPayPal pal = new PayPal();
				service.Acquista(PagamentoFactory.getPayPalAdapter(pal));
			}else {
				IMastercard mast = new MasterCard();
				service.Acquista(PagamentoFactory.getMastercardAdapter(mast));
			}
			Carrello.getInstance().svuota();
			NavigazioneController.getNcontroller().apriQR();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void Riepilogo() {
		view.setTotale(Carrello.getInstance().getTotale());
	}
	
	

}
