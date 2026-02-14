package it.unipv.posw.Model.Service;


import java.util.List;

import it.unipv.posw.Exception.IndisponibilitàException;
import it.unipv.posw.Exception.SuperamentoLimiteBigliettiException;
import it.unipv.posw.Model.Biglietto;
import it.unipv.posw.Model.Carrello;
import it.unipv.posw.Persistence.DAO.BigliettoDAO;

public class CarrelloService {
	private BigliettoDAO dao;

    public CarrelloService() {
        this.dao = new BigliettoDAO();
    }

    public void aggiungiAlCarrello(int idEvento, String tipo, int quantita) throws IndisponibilitàException, SuperamentoLimiteBigliettiException {
    	List<Biglietto> listaBiglietti = dao.getBigliettiDisponibili(idEvento, tipo, quantita);
    	
    	int giàInCarrello = 0;
        for (Biglietto b : Carrello.getInstance().getItems()) {
            if (b.getId_evento() == idEvento) {
                giàInCarrello++;
            }
        }
        
        //verifico disponibilità
    	if(listaBiglietti.size() < quantita) {
    		throw new IndisponibilitàException();
    	}
    	
        // Verifico il limite dei 4 biglietti
        if (giàInCarrello + quantita > 4) {
            throw new SuperamentoLimiteBigliettiException();
        }
        
    	
    	for(Biglietto b: listaBiglietti) {
    		Carrello.getInstance().aggiungi(b);
    	}
    	
    }

}
