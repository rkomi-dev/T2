package it.unipv.posw.Model;

public class Sessione {
	
	private static Sessione instance;
    private Cliente utenteLoggato; 
    private String qr_attuale;

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
    
	
    public void setQr_attuale(String qr_attuale) {
		this.qr_attuale = qr_attuale;
	}
    
    
	public String getQr_attuale() {
		return qr_attuale;
	}

	public void svuotaSessione() {
    	this.utenteLoggato = null;
    	this.qr_attuale = null;
    }

}
