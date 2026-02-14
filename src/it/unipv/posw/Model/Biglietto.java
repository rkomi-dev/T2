package it.unipv.posw.Model;

public class Biglietto {
	
	private int id_biglietto;
	private int id_evento;
	private Integer id_posto;
	private int id_settore;
	private String email_cliente;
	private String nominativo;
	private String stato; 
    private String qrCode;

    
    private double prezzo; 
    private String tipo;
	/**
	 * @param id_biglietto
	 * @param id_evento
	 * @param id_posto
	 * @param id_settore
	 * @param email_cliente
	 * @param nominativo
	 * @param stato
	 * @param qrCode
	 * @param prezzo
	 * @param tipo
	 */
	public Biglietto(int id_biglietto, int id_evento, Integer id_posto, int id_settore, String email_cliente,
			String nominativo, String stato, String qrCode, double prezzo, String tipo) {
		super();
		this.id_biglietto = id_biglietto;
		this.id_evento = id_evento;
		this.id_posto = id_posto;
		this.id_settore = id_settore;
		this.email_cliente = email_cliente;
		this.nominativo = nominativo;
		this.stato = stato;
		this.qrCode = qrCode;
		this.prezzo = prezzo;
		this.tipo = tipo;
	}
	public int getId_biglietto() {
		return id_biglietto;
	}
	public void setId_biglietto(int id_biglietto) {
		this.id_biglietto = id_biglietto;
	}
	public int getId_evento() {
		return id_evento;
	}
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	public int getId_posto() {
		return id_posto;
	}
	public void setId_posto(int id_posto) {
		this.id_posto = id_posto;
	}
	public int getId_settore() {
		return id_settore;
	}
	public void setId_settore(int id_settore) {
		this.id_settore = id_settore;
	}
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	public String getNominativo() {
		return nominativo;
	}
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
    

}
