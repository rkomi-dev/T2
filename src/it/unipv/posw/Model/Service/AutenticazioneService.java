package it.unipv.posw.Model.Service;

import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Persistence.DAO.ClienteDAO;

public class AutenticazioneService {
	
	private ClienteDAO clienteDAO;

	public AutenticazioneService() {
		this.clienteDAO = new ClienteDAO();
	}

	public Cliente login(String email, String password) {
	    Cliente cliente = clienteDAO.trovaClientePerEmail(email);

	    if (cliente != null && cliente.getPassword().equals(password)) {
	        return cliente; // Login riuscito
	    }
	    return null; // Credenziali errate
	}
	
}
