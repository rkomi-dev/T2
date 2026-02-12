package it.unipv.posw.Controller;

import java.util.List;

import it.unipv.posw.Model.Evento;
import it.unipv.posw.View.EventiPerArtistaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EventiPerArtistaController {
	
	private EventiPerArtistaView view;
    private List<?> eventi;

    public EventiPerArtistaController(EventiPerArtistaView view, List<?> eventi) {
        this.view = view;
        this.eventi = eventi;
        inizializza();
    }

    private void inizializza() {
    	for (Object obj : eventi) {
            final Evento e = (Evento) obj; // Rendiamo il riferimento final
            
            // Chiediamo alla view di creare la riga e darci il bottone
            Button btn = view.aggiungiEventoAllaLista(e);

            // Gestione evento senza lambda
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // Navigazione verso la vista singola (quella con la combo)
                    NavigazioneController.getNcontroller().apriEvento(e);
                }
            });
        }
    }
	
	

}
