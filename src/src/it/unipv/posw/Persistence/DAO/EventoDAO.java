package it.unipv.posw.Persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unipv.posw.Model.Evento;
import it.unipv.posw.Persistence.DBConnection;

public class EventoDAO {
	
	public List<Evento> cercaEventiPerNome(String parziale) {
	    List<Evento> risultati = new ArrayList<>();
	    String query = "SELECT * FROM Evento WHERE nome LIKE ?"; // Usiamo LIKE

	    try (
	    	Connection conn = DBConnection.startConnection(null, "TicketTwo");
	        PreparedStatement pstmt = conn.prepareStatement(query)) {
	        
	        pstmt.setString(1, parziale + "%"); // Cerca tutto ciò che inizia con 'parziale'
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            risultati.add(new Evento(
	                rs.getInt("id_evento"),
	                rs.getString("nome"),
	                rs.getTimestamp("data_ora").toLocalDateTime(),
	                rs.getString("tipologia"),
	                rs.getString("id_sede"),
	                rs.getString("email_organizzatore") 
	            ));
	        }
	    } catch (SQLException e) { e.printStackTrace(); }
	    return risultati;
	}

}
