package it.unipv.posw.Controller;

import it.unipv.posw.Model.Evento;
import it.unipv.posw.Model.Service.IRicercaStrategy;
import it.unipv.posw.Model.Service.RicercaPerArtista;
import it.unipv.posw.Model.Service.RicercaPerEvento;
import it.unipv.posw.View.RicercaView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

import java.util.List;

public class RicercaController {
	private RicercaView view;
    private IRicercaStrategy strategiaAttuale;
    private ContextMenu popupSuggerimenti;

    public RicercaController(RicercaView view) {
        this.view = view;
        this.popupSuggerimenti = new ContextMenu();
        // Default
        this.strategiaAttuale = new RicercaPerEvento(); 

        inizializzaListener();
    }

    private void inizializzaListener() {
        // Listener per la ComboBox (Versione Java 7)
        view.getComboTipoRicerca().valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if ("per: Artista".equals(newValue)) {
                    strategiaAttuale = new RicercaPerArtista();
                } else {
                    strategiaAttuale = new RicercaPerEvento();
                }
                popupSuggerimenti.hide();
            }
        });

        // Listener per il testo (quello che avevi già scritto tu, perfetto così)
        view.getTxtRicerca().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue == null || newValue.trim().length() < 2) {
                    popupSuggerimenti.hide();
                } else {
                    // La strategia fa il lavoro sporco
                    List<?> risultati = strategiaAttuale.ricerca(newValue);
                    
                    if (risultati == null || risultati.isEmpty()) {
                        popupSuggerimenti.hide();
                    } else {
                        popolaSuggerimenti(risultati);
                    }
                }
            }
        });
    }

    private void popolaSuggerimenti(List<?> risultati) {
        popupSuggerimenti.getItems().clear();

        for (int i = 0; i < risultati.size(); i++) {
            final Object scelta = risultati.get(i);
            
            // Usiamo il metodo della strategia per l'etichetta
            MenuItem item = new MenuItem(strategiaAttuale.getEtichettaSuggerimento(scelta));

            // EventHandler classico (Java 7)
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                	
                	
                	if(strategiaAttuale.getDestinazione().equals("EventiPerArtistaView")) {
                		
                        List<Evento> lista_eventi = strategiaAttuale.EventiPerArtista(strategiaAttuale.getEtichettaSuggerimento(scelta));
                		NavigazioneController.getNcontroller().apriEventiPerArtista(strategiaAttuale.getEtichettaSuggerimento(scelta), lista_eventi);
                	}
                	
                	if(strategiaAttuale.getDestinazione().equals("EventoView")) {
                		
                		NavigazioneController.getNcontroller().apriEvento((Evento)scelta);
                	}
                }
            });

            popupSuggerimenti.getItems().add(item);
        }

        if (!popupSuggerimenti.isShowing()) {
            popupSuggerimenti.show(view.getTxtRicerca(), Side.BOTTOM, 0, 0);
        }
    }
}