package it.unipv.posw.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    /**
     * Apre la connessione al database MySQL.
     * @param conn La variabile Connection da inizializzare
     * @param schema Il nome del database (es. "TicketTwo")
     * @return La connessione aperta o null in caso di errore
     */
    public static Connection startConnection(Connection conn, String schema) {
        // Stringa di connessione: sostituisci l'IP con localhost se il DB è sul tuo PC
        String DbURL = "jdbc:mysql://localhost:3306/" + schema;
        String username = "user"; 
        String password = "change123"; 

        try {
            // Caricamento del Driver JDBC per MySQL 8
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Tentativo di stabilire la connessione
            conn = DriverManager.getConnection(DbURL, username, password);
            System.out.println("Connessione riuscita allo schema: " + schema);
            
        } catch (ClassNotFoundException e) {
            System.err.println("Errore: Driver MySQL non trovato nel progetto!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Errore: Impossibile connettersi al database. Controlla URL, user e password.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conn;
    }

    /**
     * Chiude la connessione se aperta.
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connessione chiusa con successo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica se la connessione è attiva.
     */
    public static boolean isOpen(Connection conn) {
        try {
            return (conn != null && !conn.isClosed());
        } catch (SQLException e) {
            return false;
        }
    }
}
