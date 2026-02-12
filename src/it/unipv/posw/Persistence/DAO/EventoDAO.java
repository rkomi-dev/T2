package it.unipv.posw.Persistence.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unipv.posw.Model.Evento;
import it.unipv.posw.Persistence.DBConnection;
import it.unipv.posw.Persistence.DAO.Interface.IEventoDAO;

public class EventoDAO implements IEventoDAO {
	
	private Connection c;
	
	public EventoDAO() {
	}

	@Override
	public List<Evento> trovaEventiPerNome(String parziale) {
	    List<Evento> risultati = new ArrayList<>();
	    String query = "SELECT * FROM Evento WHERE nome LIKE ?"; // Usiamo LIKE
	    
	
	    try {
	    	
	    	c = DBConnection.getInstance().startConnection();
	    	
	        PreparedStatement pstmt = c.prepareStatement(query);
	        
	        pstmt.setString(1, parziale + "%"); // Cerca tutto ciò che inizia con 'parziale'
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            risultati.add(new Evento(
	                rs.getInt("id_evento"),
	                rs.getString("nome"),
	                rs.getTimestamp("data_ora").toLocalDateTime(),
	                rs.getString("tipologia"),
	                rs.getString("id_sede"),
	                rs.getString("email_organizzatore"),
	                rs.getInt("id_artista")
	            ));
	        }
	        
	    } catch (SQLException e) { 
	    	e.printStackTrace(); 
	    }
	    DBConnection.getInstance().closeConnection(c);
	    return risultati;
	}

	@Override
	public List<Evento> trovaEventiPerArtista(String parziale) {
		List<Evento> risultati = new ArrayList<>();
	    String query = "SELECT * FROM Evento JOIN Artista ON Evento.id_artista = Artista.id_artista WHERE nome_darte LIKE ?"; // Usiamo LIKE
	    
	
	    try {
	    	
	    	c = DBConnection.getInstance().startConnection();
	    	
	        PreparedStatement pstmt = c.prepareStatement(query);
	        
	        pstmt.setString(1, parziale + "%"); // Cerca tutto ciò che inizia con 'parziale'
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            risultati.add(new Evento(
	                rs.getInt("id_evento"),
	                rs.getString("nome"),
	                rs.getTimestamp("data_ora").toLocalDateTime(),
	                rs.getString("tipologia"),
	                rs.getString("id_sede"),
	                rs.getString("email_organizzatore"),
	                rs.getInt("id_artista")
	              
	            ));
	        }
	        
	    } catch (SQLException e) { 
	    	e.printStackTrace(); 
	    }
	    DBConnection.getInstance().closeConnection(c);
	    return risultati;
	}
	
	

}
