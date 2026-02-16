package it.unipv.posw.Model.Service;

import it.unipv.posw.Exception.CredenzialiErrateException;
import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Persistence.DAO.ClienteDAO;

public class AutenticazioneService {
	
	private ClienteDAO clienteDAO;

	public AutenticazioneService() {
		this.clienteDAO = new ClienteDAO();
	}

	public Cliente login(String email, String password) throws CredenzialiErrateException {
	    Cliente cliente = clienteDAO.trovaClientePerEmail(email);
	    
	    if(cliente == null || !cliente.getEmail().equals(email) || !cliente.getPassword().equals(password)) {
	    	throw new CredenzialiErrateException();
	    }
	    
		return cliente;
	}
	
}
	
