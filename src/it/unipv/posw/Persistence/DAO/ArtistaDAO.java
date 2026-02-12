package it.unipv.posw.Persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unipv.posw.Model.Artista;
import it.unipv.posw.Persistence.DBConnection;
import it.unipv.posw.Persistence.DAO.Interface.IArtistaDAO;

public class ArtistaDAO implements IArtistaDAO {
	
	private Connection c;
	
	public ArtistaDAO() {
	}


	@Override
	public List<Artista> trovaArtisti(String parziale) {
		List<Artista> risultati = new ArrayList<>();
	    // Usiamo la nuova tabella Artista
	    String query = "SELECT * FROM Artista WHERE nome_darte LIKE ?";

	    try {
	        c = DBConnection.getInstance().startConnection();
	        PreparedStatement pstmt = c.prepareStatement(query);
	        pstmt.setString(1, parziale + "%");
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            // Creiamo l'oggetto Artista con i dati dal DB
	            risultati.add(new Artista(
	                rs.getInt("id_artista"),
	                rs.getString("nome_darte")              
	            ));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.getInstance().closeConnection(c);
	    }
	    return risultati;
	}

}
