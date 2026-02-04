package it.unipv.posw.Model;

import java.time.LocalDate;

public class Cliente {
	
	private String nome;
	private String cognome;
	private LocalDate data_nascita;
	private String email;
	private String password;
	/**
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param email
	 * @param password
	 */
	public Cliente(String nome, String cognome, LocalDate data_nascita, String email, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.email = email;
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getData_nascita() {
		return data_nascita;
	}
	public void setData_nascita(LocalDate data_nascita) {
		this.data_nascita = data_nascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
