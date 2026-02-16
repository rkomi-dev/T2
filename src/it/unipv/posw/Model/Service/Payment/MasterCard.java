package it.unipv.posw.Model.Service.Payment;

public class MasterCard implements IMastercard {
	
	public MasterCard() {
		super();
	}


	@Override
	public boolean pagaMastercard() {
		System.out.println("pagato con Mastercard");
		return true;
	}

}
