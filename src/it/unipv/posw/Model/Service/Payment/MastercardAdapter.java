package it.unipv.posw.Model.Service.Payment;

public class MastercardAdapter implements IPagamento {
	
	IMastercard mast;
	
	/**
	 * @param mast
	 */
	public MastercardAdapter(IMastercard mast) {
		super();
		this.mast = mast;
	}


	@Override
	public boolean Paga(double importo) {
		mast.pagaMastercard();
		return true;
	}

}
