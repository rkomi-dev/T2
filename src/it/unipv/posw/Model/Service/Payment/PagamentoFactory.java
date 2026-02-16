package it.unipv.posw.Model.Service.Payment;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;


public class PagamentoFactory {
	
	private static final String P_PROPERTYNAME = "PayPal.adapter.class.name";
	private static final String M_PROPERTYNAME = "Mastercard.adapter.class.name";
	
	public static PayPalAdapter getPayPalAdapter(IPayPal pay) {
		
		String PayPalAdaptClassName;
		PayPalAdapter padapter = null;
	
		try {
			Properties p = new Properties(System.getProperties());
			p.load(new FileInputStream("src/Properties/properties"));
			PayPalAdaptClassName = p.getProperty(P_PROPERTYNAME);
		
			Constructor c = Class.forName(PayPalAdaptClassName).getConstructor(IPayPal.class);
			padapter = (PayPalAdapter)c.newInstance(pay);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	return padapter;
	}
	
	public static MastercardAdapter getMastercardAdapter(IMastercard mast) {
		
		String MastercardAdaptClassName;
		MastercardAdapter madapter = null;
	
		try {
			Properties p = new Properties(System.getProperties());
			p.load(new FileInputStream("src/Properties/properties"));
			MastercardAdaptClassName = p.getProperty(M_PROPERTYNAME);
		
			Constructor c = Class.forName(MastercardAdaptClassName).getConstructor(IMastercard.class);
			madapter = (MastercardAdapter)c.newInstance(mast);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	return madapter;
	}

}
