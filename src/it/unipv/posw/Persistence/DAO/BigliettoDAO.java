package it.unipv.posw.Persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unipv.posw.Model.Biglietto;
import it.unipv.posw.Model.RiepilogoAcquisto;
import it.unipv.posw.Persistence.DBConnection;
import it.unipv.posw.Persistence.DAO.Interface.IBigliettoDAO;

public class BigliettoDAO implements IBigliettoDAO {
	
	private Connection c;
	
	public BigliettoDAO() {}

	@Override
	public List<Biglietto> getBigliettiDisponibili(int idEvento, String tipo, int quantita) {
		
		List<Biglietto> risultati = new ArrayList<>();
		PreparedStatement ps;
		String query = "SELECT b.*, t.prezzo_finale, t.tipologia_biglietto " +
                "FROM Biglietto b " +
                "JOIN Tariffa t ON b.id_evento = t.id_evento AND b.id_settore = t.id_settore " +
                "WHERE b.id_evento = ? " +
                "AND t.tipologia_biglietto = ? " +
                "AND b.stato IS NULL " +
                "LIMIT ?";
		
		try {
			c = DBConnection.getInstance().startConnection();
			ps = c.prepareStatement(query); 
		        
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
		}finally {
			DBConnection.getInstance().closeConnection(c);
		}
		return risultati;
	}

	@Override
	public void updatePostAcquisto(int id_biglietto, String email, String nominativo, String qr) {
		
		PreparedStatement ps;
		String query = "UPDATE Biglietto SET email_cliente = ?, nominativo = ?, qr_code = ?, stato = 'acquistato' WHERE id_biglietto = ?";
		
		try {
			c = DBConnection.getInstance().startConnection();
			ps = c.prepareStatement(query); 
			
			ps.setString(1, email);
	        ps.setString(2, nominativo);
	        ps.setString(3, qr);
	        ps.setInt(4, id_biglietto);
	        
	        ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.getInstance().closeConnection(c);
		}
	}

	@Override
	public List<RiepilogoAcquisto> getBigliettiAcquistati(String email) {
		
		List<RiepilogoAcquisto> risultati = new ArrayList<>();
		PreparedStatement ps;
		String query = "SELECT e.nome, e.data_ora, b.nominativo, b.qr_code, t.prezzo_finale " +
                "FROM Biglietto b " +
                "JOIN Evento e ON b.id_evento = e.id_evento " +
                "JOIN Tariffa t ON e.id_evento = t.id_evento AND b.id_settore = t.id_settore " +
                "WHERE b.email_cliente = ? AND b.stato = 'acquistato'";
		
		try {
			c = DBConnection.getInstance().startConnection();
			ps = c.prepareStatement(query);
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
	            risultati.add(new RiepilogoAcquisto(
	                rs.getString("nome"),
	                rs.getTimestamp("data_ora").toLocalDateTime(),
	                rs.getString("nominativo"),
	                rs.getDouble("prezzo_finale")
	            ));
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return risultati;
	}
	
}
