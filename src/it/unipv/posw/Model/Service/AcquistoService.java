package it.unipv.posw.Model.Service;

import java.util.List;

import it.unipv.posw.Model.Biglietto;
import it.unipv.posw.Model.Carrello;
import it.unipv.posw.Model.RiepilogoAcquisto;
import it.unipv.posw.Model.Sessione;
import it.unipv.posw.Model.Service.Payment.IPagamento;
import it.unipv.posw.Persistence.DAO.BigliettoDAO;

public class AcquistoService {
	
	private BigliettoDAO dao;
	private QRService qrservice;

	public AcquistoService() {
		super();
		dao = new BigliettoDAO();
	}
	
	public void Acquista(IPagamento metodo) throws Exception {
		
		boolean esito = metodo.Paga(Carrello.getInstance().getTotale());
		
		qrservice = new QRService();
		
		qrservice.Genera();
		Sessione.getInstance().setQr_attuale(qrservice.getCodice());
		
		
		for(Biglietto b : Carrello.getInstance().getItems()) {
			
			String email = Sessione.getInstance().getUtenteLoggato().getEmail();
			String nome = Sessione.getInstance().getUtenteLoggato().getNome();
			String cognome = Sessione.getInstance().getUtenteLoggato().getCognome();
			String qr = Sessione.getInstance().getQr_attuale();
			
			dao.updatePostAcquisto(b.getId_biglietto(), email, nome + " " + cognome, qr);
		}
		
		if(!esito) {
			throw new Exception();
		}
		
	}
	
	public List<RiepilogoAcquisto> storicoAcquisti(String email) {
	
		return dao.getBigliettiAcquistati(email);
	}
	
	

}
