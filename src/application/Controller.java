package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Controller {
	public void init(Stage s) {
		Pane p = new Pane();
		Button b = new Button();
		b.setText("no funciona");
		b.setShape(new Circle(20));
		b.setMinSize(40, 40);
		b.setMaxSize(40, 40);
		p.getChildren().add(b);
		Scene sc = new Scene(p);
		s.setScene(sc);
		s.show();
		
	}
}
