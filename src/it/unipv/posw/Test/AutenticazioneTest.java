package it.unipv.posw.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unipv.posw.Exception.CredenzialiErrateException;
import it.unipv.posw.Model.Cliente;
import it.unipv.posw.Model.Service.AutenticazioneService;
import it.unipv.posw.Persistence.DAO.ClienteDAO;


public class AutenticazioneTest {
	
	private AutenticazioneService service;
	private ClienteDAO dao;
	private Cliente c;
	
	@Before
	public void iniTest() {
		service = new AutenticazioneService();
		dao = new ClienteDAO();
		c = new Cliente("Luigi", "Bianchi", LocalDate.of(1984, 11, 9), "luigi.bianchi@gmail.com", "prova123" );
		
		dao.salvaCliente(c);
	}

	@Test
	public void testAutenticazioneOK() {
		boolean result = true;
		
		try {
			service.login(c.getEmail(), c.getPassword());
		} catch (Exception e) {
			result = false;
		}
		
		assertTrue(result);
	}
	
	// il cliente non esiste
	@Test
	public void testAutenticazioneKO1() {
		boolean result = true;
		
		try {
			service.login("email@inesistente.it", "qualsiasi");
		}catch (CredenzialiErrateException ex) {
			result = false;
		}
		
		assertFalse(result);
	}
	
	//credenziale errata
	@Test
	public void testAutenticazioneKO2() {
		boolean result = true;
		
		try {
			service.login(c.getEmail(), "password errata");
		} catch (CredenzialiErrateException ex) {
			result = false;
		}
		
		assertFalse(result);
	}
	
	
	@After
	public void deleteCliente() {
		dao.deleteCliente(c.getEmail());
	}

}
