package it.unipv.posw.Persistence.DAO.Interface;

import java.util.List;

import it.unipv.posw.Model.Evento;

public interface IEventoDAO {
	
	public List<Evento> trovaEventiPerNome(String parziale);
	public List<Evento> trovaEventiPerArtista(String parziale);

}
