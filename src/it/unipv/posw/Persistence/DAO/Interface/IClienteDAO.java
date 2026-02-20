package it.unipv.posw.Persistence.DAO.Interface;

import it.unipv.posw.Model.Cliente;

public interface IClienteDAO {
	
	boolean isEmailEsistente(String email);
	boolean salvaCliente(Cliente cliente);
    Cliente trovaClientePerEmail(String email);
    boolean deleteCliente(String email);

}
