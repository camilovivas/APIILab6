package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Controller c;
	
	public Main() {
		c = new Controller();		
	}
	@Override
	public void start(Stage primaryStage) {
			c.welcome(primaryStage);
			primaryStage.setTitle("Atrapalas Ya");
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
