package it.unipv.posw.Model;

import java.time.LocalDateTime;

public class Evento {
	
	private int id_evento;
	private String nome;
	private LocalDateTime dataora;
	private String tipologia;
	private String id_sede;
	private String email_organizztore;
	private int id_artista; 
	/**
	 * @param id_evento
	 * @param nome
	 * @param dataora
	 * @param tipologia
	 * @param id_sede
	 * @param email_organizztore
	 */
	public Evento(int id_evento, String nome, LocalDateTime dataora, String tipologia, String id_sede,
			String email_organizztore, int id_artista) {
		super();
		this.id_evento = id_evento;
		this.nome = nome;
		this.dataora = dataora;
		this.tipologia = tipologia;
		this.id_sede = id_sede;
		this.email_organizztore = email_organizztore;
		this.id_artista = id_artista;
		
	}
	public int getId_evento() {
		return id_evento;
	}
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDateTime getDataora() {
		return dataora;
	}
	public void setDataora(LocalDateTime dataora) {
		this.dataora = dataora;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getId_sede() {
		return id_sede;
	}
	public void setId_sede(String id_sede) {
		this.id_sede = id_sede;
	}
	public String getEmail_organizztore() {
		return email_organizztore;
	}
	public void setEmail_organizztore(String email_organizztore) {
		this.email_organizztore = email_organizztore;
	}
	public int getId_Artista() {
		return id_artista;
	}
	
	
	
	

}
