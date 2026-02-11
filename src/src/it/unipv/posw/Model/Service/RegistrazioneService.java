package it.unipv.posw.Model.Service;

import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Persistence.DAO.ClienteDAO;

public class RegistrazioneService {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public String registraNuovoCliente(Cliente cliente) {
        // Logica di Business: Esempio di validazione
        if (cliente.getEmail().isEmpty() || !cliente.getEmail().contains("@")) {
            return "Email non valida!";
        }
        
        // Chiamata al DAO
        boolean successo = clienteDAO.salvaCliente(cliente);
        
        if (successo) {
            return "OK";
        } else {
            return "Errore: Email già esistente o problema al server.";
        }
    }
}
