package it.unipv.posw.Persistence.DAO.Interface;

import it.unipv.posw.Model.Cliente;

public interface IClienteDAO {
	
	boolean salvaCliente(Cliente cliente);
    Cliente trovaClientePerEmail(String email);

}
