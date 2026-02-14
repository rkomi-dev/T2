import it.unipv.posw.Controller.HomeController;
import it.unipv.posw.View.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runner extends Application {
	
	private HomeView view;

    @Override
    public void start(Stage primaryStage) {
        
       view = new HomeView();

       new HomeController(view);

       Scene scene = new Scene(view, 800, 600);

       primaryStage.setTitle("TicketTwo");
       primaryStage.setScene(scene);
        
       primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}