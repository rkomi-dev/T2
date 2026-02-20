package it.unipv.posw.Test;

import static org.junit.Assert.*;


import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import it.unipv.posw.Exception.EmailEsistenteException;
import it.unipv.posw.Exception.EmptyFieldException;
import it.unipv.posw.Exception.WrongEmailFormatException;
import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Model.Service.RegistrazioneService;
import it.unipv.posw.Persistence.DAO.ClienteDAO;

public class RegistrazioneTest {
	
	private RegistrazioneService service;
	
	@Before
	public void iniTest() {
		service = new RegistrazioneService();
	}
	
	@Test
	public void testRegistrazioneOK() throws EmptyFieldException, WrongEmailFormatException, EmailEsistenteException {
		
		boolean result;
		Cliente c = new Cliente("Luigi", "Bianchi", LocalDate.of(1984, 11, 9), "luigi.bianchi@gmail.com", "prova123" );
		ClienteDAO dao = new ClienteDAO();
		result = service.registraNuovoCliente(c);
		
		dao.deleteCliente(c.getEmail());
		assertTrue(result);
	}
	
	@Test
	public void testRegistrazioneKO1() throws WrongEmailFormatException, EmailEsistenteException {
		boolean result;
		Cliente c = new Cliente("", "Bianchi", LocalDate.of(1984, 11, 9), "", "prova123" );
		
		try {
			 result = service.registraNuovoCliente(c);
		}catch (EmptyFieldException ex) {
			 result = false;
		}
		
		assertFalse(result);
	}
	
	@Test
	public void testRegistrazioneKO2() throws EmptyFieldException, EmailEsistenteException {
		
		boolean result;
		Cliente c = new Cliente("Luigi", "Bianchi", LocalDate.of(1984, 11, 9), "luigi.bianchigmail.com", "prova123" );
		
		try {
			result = service.registraNuovoCliente(c);
		}catch (WrongEmailFormatException ex) {
			result = false;
		}
		
		assertFalse(result);
	}
	
	@Test
	public void testRegistrazioneKO3() throws EmptyFieldException, WrongEmailFormatException {
		
		boolean result;
		Cliente c = new Cliente("Luigi", "Bianchi", LocalDate.of(1984, 11, 9), "luigi.bianchi@gmail.com", "prova123" );
		ClienteDAO dao = new ClienteDAO();
		
		try {
			service.registraNuovoCliente(c);
			
			result = service.registraNuovoCliente(c);
		}catch (EmailEsistenteException ex) {
			result = false;
		}
		
		dao.deleteCliente(c.getEmail());
		assertFalse(result);
	}
	
	

}
