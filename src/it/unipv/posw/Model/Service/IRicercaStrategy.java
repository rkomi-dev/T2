package it.unipv.posw.Model.Service;

import java.util.List;

import it.unipv.posw.Model.Evento;

public interface IRicercaStrategy {
	
	List<?> ricerca(String query);
	String getDestinazione();
	String getEtichettaSuggerimento(Object o);
	List <Evento> EventiPerArtista(String query);
}
