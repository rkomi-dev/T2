package it.unipv.posw.Persistence.DAO;

import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Persistence.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public boolean salvaCliente(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String query = "INSERT INTO Utente (nome, cognome, email, password, data_nascita) VALUES (?, ?, ?, ?, ?)";

        try {
            // Utilizziamo il tuo metodo startConnection
            conn = DBConnection.startConnection(null, "TicketTwo");
            
            if (conn == null) return false;

            pstmt = conn.prepareStatement(query);
    
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCognome());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getPassword());
            pstmt.setDate(5, java.sql.Date.valueOf(cliente.getData_nascita()));

            int result = pstmt.executeUpdate();
            return result > 0; // Ritorna true se l'inserimento è riuscito

        } catch (SQLException e) {
            System.err.println("Errore durante la registrazione: " + e.getMessage());
            return false;
        } finally {
            // Ricordati di chiudere sempre le risorse
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
            DBConnection.closeConnection(conn);
        }
    }
    
    public Cliente trovaClientePerEmail(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        String query = "SELECT * FROM Utente WHERE email = ?";

        try {
            conn = DBConnection.startConnection(null, "TicketTwo");
            pstmt = conn.prepareStatement(query);
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
            DBConnection.closeConnection(conn);
        }
        return cliente;
    }
}