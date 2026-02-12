package it.unipv.posw.Persistence.DAO;

import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Persistence.DBConnection;
import it.unipv.posw.Persistence.DAO.Interface.IClienteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO implements IClienteDAO {
	
	private Connection c;
	
	public ClienteDAO() {
	}

	@Override
    public boolean salvaCliente(Cliente cliente) {
        PreparedStatement pstmt = null;
        String query = "INSERT INTO Utente (nome, cognome, email, password, data_nascita) VALUES (?, ?, ?, ?, ?)";

        try {
            // Utilizziamo il tuo metodo startConnection
            c = DBConnection.getInstance().startConnection();
            
            if (c == null) return false;

            pstmt = c.prepareStatement(query);
    
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCognome());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getPassword());
            pstmt.setDate(5, java.sql.Date.valueOf(cliente.getData_nascita()));

            int result = pstmt.executeUpdate();
            DBConnection.getInstance().closeConnection(c);
            return result > 0; // Ritorna true se l'inserimento è riuscito

        } catch (SQLException e) {
            System.err.println("Errore durante la registrazione: " + e.getMessage());
            return false;
        } finally {
            DBConnection.getInstance().closeConnection(c);
        }
          
    }
    
    
	@Override
    public Cliente trovaClientePerEmail(String email) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        String query = "SELECT * FROM Utente WHERE email = ?";

        try {
            c = DBConnection.getInstance().startConnection();
            pstmt = c.prepareStatement(query);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Se lo trovo, costruisco l'oggetto Cliente
                cliente = new Cliente(
                    
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getDate("data_nascita").toLocalDate(),
                    rs.getString("email"),
                    rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(c);
        }
        return cliente;
    }
}