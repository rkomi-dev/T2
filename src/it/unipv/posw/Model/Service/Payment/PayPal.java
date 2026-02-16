package it.unipv.posw.Model.Service.Payment;

public class PayPal implements IPayPal {

	public PayPal() {
		super();
	}


	@Override
	public boolean pagaPayPal() {
		System.out.println("pagato con PayPal");
		return true;
	}

}
