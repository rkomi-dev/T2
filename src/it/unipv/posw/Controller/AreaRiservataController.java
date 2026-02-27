package it.unipv.posw.Controller;

import java.util.List;

import it.unipv.posw.Model.RiepilogoAcquisto;
import it.unipv.posw.Model.Sessione;
import it.unipv.posw.Model.Service.AcquistoService;
import it.unipv.posw.View.AreaRiservataView;

public class AreaRiservataController {
	
	private AreaRiservataView view;
    private AcquistoService service;

    public AreaRiservataController(AreaRiservataView view) {
        this.view = view;
        this.service = new AcquistoService();
        caricaDati();
    }

    private void caricaDati() {
    	
    		List<RiepilogoAcquisto> acquisti = service.storicoAcquisti(Sessione.getInstance().getUtenteLoggato().getEmail());
        
    		for (RiepilogoAcquisto a : acquisti) {
           
    			String riga = String.format("%s | Data: %s | Intestato a: %s | €%.2f",
    					a.getNomeEvento(),
    					a.getDataOraEvento().toLocalDate(), 
    					a.getNominativo(),
    					a.getPrezzo()
    					);
            
    			view.getListaAcquisti().getItems().add(riga);
    		}
    	
    }

}
