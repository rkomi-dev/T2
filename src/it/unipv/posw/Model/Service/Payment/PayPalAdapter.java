package it.unipv.posw.Model.Service.Payment;

public class PayPalAdapter implements IPagamento {
	
	IPayPal pay;
	
	/**
	 * @param pay
	 */
	public PayPalAdapter(IPayPal pay) {
		super();
		this.pay = pay;
	}


	@Override
	public boolean Paga(double importo) {
		pay.pagaPayPal();
		return true;
	}

}
