package it.unipv.posw.Persistence.DAO.Interface;

import java.util.List;

import it.unipv.posw.Model.Biglietto;

public interface IBigliettoDAO {
	
	List<Biglietto> getBigliettiDisponibili(int idEvento, String tipo, int quantita);

}
