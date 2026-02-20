package it.unipv.posw.Model.Service;

import it.unipv.posw.Exception.EmailEsistenteException;
import it.unipv.posw.Exception.EmptyFieldException;
import it.unipv.posw.Exception.WrongEmailFormatException;
import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Persistence.DAO.ClienteDAO;

public class RegistrazioneService {
    private ClienteDAO dao;
    
	public RegistrazioneService() {
		this.dao = new ClienteDAO();
	}

	public boolean registraNuovoCliente(Cliente cliente) throws EmptyFieldException, WrongEmailFormatException, EmailEsistenteException {
        
        if (cliente.getNome().isEmpty() || cliente.getCognome().isEmpty() ||cliente.getEmail().isEmpty()
        	 ||	cliente.getPassword().isEmpty() || cliente.getData_nascita() == null) {
            throw new EmptyFieldException();
        }
        
        if(!cliente.getEmail().contains("@")) {
        	throw new WrongEmailFormatException();
        }
        
        if(dao.isEmailEsistente(cliente.getEmail())) {
        	throw new EmailEsistenteException();
        }
        
        dao.salvaCliente(cliente);
        return true;
       
    }
}
