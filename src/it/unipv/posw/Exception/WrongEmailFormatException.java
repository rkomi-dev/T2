package it.unipv.posw.Exception;

public class WrongEmailFormatException extends Exception {

	
	public WrongEmailFormatException() {
		super("l'email deve contenere '@'");
	}
	
	

}
