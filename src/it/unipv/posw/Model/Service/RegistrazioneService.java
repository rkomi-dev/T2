package it.unipv.posw.Model.Service;

import it.unipv.posw.Exception.EmptyFieldException;
import it.unipv.posw.Exception.WrongEmailFormatException;
import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Persistence.DAO.ClienteDAO;

public class RegistrazioneService {
    private ClienteDAO clienteDAO;
    
	public RegistrazioneService() {
		this.clienteDAO = new ClienteDAO();
	}

	public void registraNuovoCliente(Cliente cliente) throws EmptyFieldException, WrongEmailFormatException {
        
        if (cliente.getNome().isEmpty() || cliente.getCognome().isEmpty() ||cliente.getEmail().isEmpty()
        	 ||	cliente.getPassword().isEmpty() || cliente.getData_nascita().isEqual(null)) {
            throw new EmptyFieldException();
        }
        
        if(!cliente.getEmail().contains("@")) {
        	throw new WrongEmailFormatException();
        }
        
        clienteDAO.salvaCliente(cliente);
       
    }
}
