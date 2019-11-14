package application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Controller {
	public void init(Stage s) {
		Group p = new Group();
		Button b = new Button();
		b.setShape(new Circle(40));
		b.setMinSize(80, 80);
		b.setMaxSize(80, 80);
		p.getChildren().add(b);
		Scene sc = new Scene(p);
		s.setScene(sc);
		s.show();
		
	}
}
