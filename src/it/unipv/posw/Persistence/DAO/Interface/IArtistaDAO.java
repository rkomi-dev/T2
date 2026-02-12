package it.unipv.posw.Persistence.DAO.Interface;

import java.util.List;

import it.unipv.posw.Model.Artista;

public interface IArtistaDAO {
	
	List<Artista> trovaArtisti(String parziale);

}
