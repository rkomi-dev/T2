package it.unipv.posw.Controller;

import it.unipv.posw.Model.Sessione;
import it.unipv.posw.View.QRView;

public class QRController {
	
	private QRView view;
	/**
	 * @param view
	 */
	public QRController(QRView view) {
		super();
		this.view = view;

		impostaCodice();
	}
	
	public void impostaCodice() {
		view.setCodiceTestuale(Sessione.getInstance().getQr_attuale());
		
	}

}
