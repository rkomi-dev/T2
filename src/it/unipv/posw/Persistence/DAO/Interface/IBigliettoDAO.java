package it.unipv.posw.Persistence.DAO.Interface;

import java.util.List;

import it.unipv.posw.Model.Biglietto;
import it.unipv.posw.Model.RiepilogoAcquisto;

public interface IBigliettoDAO {
	
	List<Biglietto> getBigliettiDisponibili(int idEvento, String tipo, int quantita);
	void updatePostAcquisto(int id, String email, String nome, String qr);
	List<RiepilogoAcquisto> getBigliettiAcquistati(String email);
}
