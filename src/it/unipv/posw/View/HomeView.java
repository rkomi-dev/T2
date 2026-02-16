package it.unipv.posw.View;

import it.unipv.posw.Controller.ViewFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class HomeView extends BorderPane {
    // Componenti del menu
    public MenuBar menuBar = new MenuBar();
    public Menu menuAccount = new Menu("\u2630"); // icona a 3 barre
    public MenuItem itemHome = new MenuItem("Home");
    public MenuItem itemLogin = new MenuItem("Login cliente");
    public MenuItem itemRegistrati = new MenuItem("Registrati");
    public HBox topBar;
    private RicercaView ricercaView;
    

    public HomeView() {

        this.getStylesheets().add(getClass().getResource("/css/common.css").toExternalForm());
        this.getStyleClass().add("root");

        
        // Configurazione Menu
        menuAccount.getItems().addAll(itemHome, itemLogin, itemRegistrati);
        menuBar.getMenus().add(menuAccount);
        
        itemHome.getStyleClass().add("button-primary");
        itemLogin.getStyleClass().add("button-primary");
        itemRegistrati.getStyleClass().add("button-primary");
        
        
        Region spacerSinistra = new Region();
        Region spacerDestra = new Region();
        HBox.setHgrow(spacerSinistra, Priority.ALWAYS);
        HBox.setHgrow(spacerDestra, Priority.ALWAYS);


        topBar = new HBox(menuBar, spacerSinistra,ViewFactory.getInstance().creaRicercaView() , spacerDestra);//, lblStatoUtente);
        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(10));
        
        //this.setTop(topBar);
        topBar.setStyle("-fx-padding: 10; -fx-background-color: white; -fx-alignment: CENTER_LEFT;");
        
        this.setTop(topBar);
        
        
    }

	public RicercaView getRicercaView() {
		return ricercaView;
	}

	public HBox getTopBar() {
		return topBar;
	}
	
	
    
    
}
