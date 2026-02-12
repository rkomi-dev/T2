package it.unipv.posw.Model.Service;

import java.util.List;

import it.unipv.posw.Model.Artista;
import it.unipv.posw.Model.Evento;
import it.unipv.posw.Persistence.DAO.ArtistaDAO;
import it.unipv.posw.Persistence.DAO.EventoDAO;

public class RicercaPerArtista implements IRicercaStrategy {
	
	private EventoDAO dao1;
	private ArtistaDAO dao2;
	
	public RicercaPerArtista() {
		this.dao1 = new EventoDAO();
		this.dao2 = new ArtistaDAO();
	}
	
	@Override
	public List <Evento> EventiPerArtista(String query) {
		return dao1.trovaEventiPerArtista(query);
	}
	
	@Override
	public List<Artista> ricerca(String query) {

		return dao2.trovaArtisti(query);
	}

	@Override
	public String getDestinazione() {
		return "EventiPerArtistaView";
		
	}

	@Override
	public String getEtichettaSuggerimento(Object o) {
		
		return ((Artista)o).getNome_darte();
	}

}
