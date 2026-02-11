package it.unipv.posw.Model.Service;

import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Persistence.DAO.ClienteDAO;

public class AutenticazioneService {
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	private boolean isLogin = false;
	
	public Cliente login(String email, String password) {
	    Cliente cliente = clienteDAO.trovaClientePerEmail(email);

	    if (cliente != null && cliente.getPassword().equals(password)) {
	    	isLogin = true;
	        return cliente; // Login riuscito
	    }
	    return null; // Credenziali errate
	}
	
	public void logout() {
		isLogin = false;
	}

}
