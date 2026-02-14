package it.unipv.posw.Persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unipv.posw.Model.Biglietto;
import it.unipv.posw.Persistence.DBConnection;
import it.unipv.posw.Persistence.DAO.Interface.IBigliettoDAO;

public class BigliettoDAO implements IBigliettoDAO {
	
	private Connection c;
	
	public BigliettoDAO() {}

	@Override
	public List<Biglietto> getBigliettiDisponibili(int idEvento, String tipo, int quantita) {
		
		List<Biglietto> risultati = new ArrayList<>();
		String query = "SELECT b.*, t.prezzo_finale, t.tipologia_biglietto " +
                "FROM Biglietto b " +
                "JOIN Tariffa t ON b.id_evento = t.id_evento AND b.id_settore = t.id_settore " +
                "WHERE b.id_evento = ? " +
                "AND t.tipologia_biglietto = ? " +
                "AND b.stato IS NULL " +
                "LIMIT ?";
		
		try {
			c = DBConnection.getInstance().startConnection();
			PreparedStatement ps = c.prepareStatement(query); 
		        
		        ps.setInt(1, idEvento);
		        ps.setString(2, tipo);
		        ps.setInt(3, quantita);

		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		        	Biglietto b = new Biglietto(
		        	        rs.getInt("id_biglietto"),
		        	        rs.getInt("id_evento"),
		        	        rs.getInt("id_posto"), 
		        	        rs.getInt("id_settore"),
		        	        rs.getString("email_cliente"),
		        	        rs.getString("nominativo"),
		        	        rs.getString("stato"),
		        	        rs.getString("qr_code"),
		        	        rs.getDouble("prezzo_finale"), // Dalla tabella Tariffa
		        	        rs.getString("tipologia_biglietto") // Dalla tabella Tariffa
		        	    );
		            risultati.add(b);
		        }
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return risultati;
	}
	
}
