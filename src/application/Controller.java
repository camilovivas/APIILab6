package application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Game;

public class Controller {
	private Game game;
	private Group group;
	
	public void init(Stage s) {
		Scene sc = new Scene(group);
		s.setScene(sc);
		s.show();
		
	}
	
	public void welcome(Stage s) {
		group = new Group();
		VBox vb = new VBox();
		Text tx = new Text ("Welcome");
		Text tx2 = new Text ("Selecciona el nivel que desea jugar");
		ChoiceBox<String> c = new ChoiceBox<String>();
		c.getItems().add("level 1");
		c.getItems().add("level 2");
		c.getItems().add("level 3");
		c.setOnAction(e->{
			create(c.getValue(), s);
			
		});
		vb.getChildren().addAll(tx, tx2, c);
		Scene sc = new Scene(vb);
		s.setScene(sc);
		s.show();
		
	}
	public void play(Stage s) {
		VBox v = new VBox(2);
		HBox h = new HBox();
		Menu mb1 = new Menu("Archivo");
		MenuItem mi0 = new MenuItem("Cargar juego");
		MenuItem mi1 = new MenuItem("Guardar juego");
		MenuItem mi2 = new MenuItem("Salir");
		mb1.getItems().addAll(mi0, mi1, mi2);
		Menu mb2 = new Menu("Ver");
		MenuItem mi3 = new MenuItem("Mejores puntajes");
		MenuItem mi4 = new MenuItem("Acerca del juego");
		mb2.getItems().addAll(mi3, mi4);
		MenuBar mb = new MenuBar(mb1,mb2);
		h.getChildren().add(mb);
		v.getChildren().addAll(h,group);
		Scene sc = new Scene(v, 400,400);
		s.setScene(sc);
		s.show();
	}
	
	public void create(String level, Stage s) {
		if(level.compareTo("level 1")==0) {
			game = new Game(1, group);
			play(s);
		}
		if(level.compareTo("level 2")==0) {
			game = new Game(2, group);
			play(s);
		}
		if(level.compareTo("level 3")==0) {
			game = new Game(3, group);
			play(s);
		}
		
	}
}
