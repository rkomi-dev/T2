import it.unipv.posw.Controller.HomeController;
import it.unipv.posw.View.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runner extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Istanza della HomeView (il guscio con Menu e Label "Ospite")
        HomeView homeView = new HomeView();

        // 2. Istanza del HomeController
        // Questo controller gestirà i click sul menu per mostrare Login o Registrazione
        new HomeController(homeView);

        // 3. Creazione della Scena con la HomeView
        // Usiamo una dimensione più generosa per ospitare i vari casi d'uso
        Scene scene = new Scene(homeView, 800, 600);

        // 4. Configurazione dello Stage
        primaryStage.setTitle("TicketTwo");
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}