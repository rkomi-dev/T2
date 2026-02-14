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
        // Logica di Business: Esempio di validazione
        if (cliente.getEmail().isEmpty()) {
            throw new EmptyFieldException();
        }
        
        if(!cliente.getEmail().contains("@")) {
        	throw new WrongEmailFormatException();
        }
        
        clienteDAO.salvaCliente(cliente);
       
    }
}
