package it.unipv.posw.Model.Service;

import java.util.List;

import it.unipv.posw.Model.Evento;
import it.unipv.posw.Persistence.DAO.EventoDAO;

public class RicercaPerEvento implements IRicercaStrategy {
	
	private EventoDAO dao;
	
	public RicercaPerEvento() {
		this.dao = new EventoDAO();
	}

	@Override
	public List<Evento> ricerca(String query) {
		
		return dao.trovaEventiPerNome(query);
	}

	

	@Override
	public String getEtichettaSuggerimento(Object o) {
		Evento e = (Evento)o;
		return e.getNome();
	}

	@Override
	public String getDestinazione() {
		
		return "EventoView";
	}

	@Override
	public List<Evento> EventiPerArtista(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
