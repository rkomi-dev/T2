package it.unipv.posw.View;

import java.time.format.DateTimeFormatter;
import java.util.List;


import it.unipv.posw.Model.Evento;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class EventiPerArtistaView extends VBox {

    private VBox listaContainer;

    public EventiPerArtistaView(String nomeArtista, List<?> e) {
        this.setSpacing(20);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.TOP_CENTER);
        this.getStylesheets().add(getClass().getResource("registrazione.css").toExternalForm());
        this.getStyleClass().add("registrazione-pane");
        // Titolo
        Label lblTitolo = new Label("Eventi per: " + nomeArtista);
        
        // Contenitore per le righe degli eventi
        listaContainer = new VBox(10);
        
        ScrollPane scrollPane = new ScrollPane(listaContainer);
        scrollPane.setFitToWidth(true);
        VBox.setVgrow(scrollPane, Priority.ALWAYS);


        this.getChildren().addAll(lblTitolo, scrollPane);
    }

    public Button aggiungiEventoAllaLista(Evento e) {
        HBox riga = new HBox(15);
        riga.setAlignment(Pos.CENTER_LEFT);
        
        // Parte testuale
        VBox info = new VBox(5);
        info.getChildren().addAll(new Label(e.getNome()), new Label(e.getDataora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));
        HBox.setHgrow(info, Priority.ALWAYS);

        // La View crea il bottone
        Button btnVedi = new Button("Visualizza Dettaglio");
        
        riga.getChildren().addAll(info, btnVedi);
        listaContainer.getChildren().add(riga);

        return btnVedi; // Restituisco il bottone al controller
    }
}
  