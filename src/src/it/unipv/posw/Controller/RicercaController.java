package it.unipv.posw.Controller;

import it.unipv.posw.Model.Evento;
import it.unipv.posw.Persistence.DAO.EventoDAO;
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
    private EventoDAO eventoDao;
    private ContextMenu popupSuggerimenti;

    public RicercaController(RicercaView view) {
        this.view = view;
        this.eventoDao = new EventoDAO();
        this.popupSuggerimenti = new ContextMenu();
        

        inizializzaListener();
    }

    private void inizializzaListener() {
        // Listener per il cambiamento del testo (TextProperty)
        view.getTxtRicerca().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Se il testo è più corto di 2 caratteri, chiudiamo il menu e usciamo
                if (newValue == null || newValue.trim().length() < 2) {
                    popupSuggerimenti.hide();
                } else {
                    // Chiamata al DAO per ottenere i risultati
                    List<Evento> risultati = eventoDao.cercaEventiPerNome(newValue);
                    
                    if (risultati == null || risultati.isEmpty()) {
                        popupSuggerimenti.hide();
                    } else {
                        popolaSuggerimenti(risultati);
                    }
                }
            }
        });
    }

    private void popolaSuggerimenti(List<Evento> risultati) {
        popupSuggerimenti.getItems().clear();

        // Usiamo un ciclo for tradizionale. La variabile 'e' deve essere final 
        // per essere usata dentro la classe anonima dell'EventHandler
        for (int i = 0; i < risultati.size(); i++) {
            final Evento eventoScelto = risultati.get(i);
            MenuItem item = new MenuItem(eventoScelto.getNome() + " (" + eventoScelto.getTipologia() + ")");

            // EventHandler per il click sul suggerimento
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // Scriviamo il nome nel campo di ricerca
                    view.getTxtRicerca().setText(eventoScelto.getNome());
                    
                    // Qui puoi gestire l'apertura dei dettagli dell'evento
                    System.out.println("Hai selezionato l'evento ID: " + eventoScelto.getId_evento());
                }
            });

            popupSuggerimenti.getItems().add(item);
        }

        // MOSTRA IL POPUP: 
        // Controlliamo che la barra di ricerca sia effettivamente "agganciata" a una finestra
        if (view.getTxtRicerca().getScene() != null && view.getTxtRicerca().getScene().getWindow() != null) {
            // Se non è già mostrato, lo apriamo sotto il TextField
            if (!popupSuggerimenti.isShowing()) {
                popupSuggerimenti.show(view.getTxtRicerca(), Side.BOTTOM, 0, 0);
            }
        }
    }
}