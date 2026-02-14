package it.unipv.posw.Model;

public class Sessione {
	
	private static Sessione instance;
    private Cliente utenteLoggato; // Questo è il "parametro" che cerchi

    private Sessione() {} // Costruttore privato per il Singleton

    public static Sessione getInstance() {
        if (instance == null) {
            instance = new Sessione();
        }
        return instance;
    }

    // Metodo per il Login: salva l'utente qui dentro
    public void login(Cliente c) {
        this.utenteLoggato = c;
    }

    // Metodo per il Logout: svuota il riferimento
    public void logout() {
        this.utenteLoggato = null;
    }

    // Il controllo che userai nell'EventoController
    public boolean isLoggato() {
        return utenteLoggato != null;
    }

    public Cliente getUtenteLoggato() {
        return utenteLoggato;
    }

	public void setUtenteLoggato(Cliente utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}
    
    

}
