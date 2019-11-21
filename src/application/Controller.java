package application;


import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		group.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				MouseButton mb = event.getButton();
				if(mb == MouseButton.PRIMARY) {
					stop(event);
					boolean win = game.winner();
					if(win == true) {
						if(game.podium()== true) {
							winer();
						}
					}
				}
				
			}
		});
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
		mi0.setOnAction(e->{
			chargeGame();
		});
		MenuItem mi1 = new MenuItem("Guardar juego");
		mi1.setOnAction(e->{
			saveGame();
		});
		MenuItem mi2 = new MenuItem("Salir");
		mi2.setOnAction(e->{
			s.close();
		});
		mb1.getItems().addAll(mi0, mi1, mi2);
		Menu mb2 = new Menu("Ver");
		MenuItem mi3 = new MenuItem("Mejores puntajes");
		mi3.setOnAction(e->{
			showHall();
		});
		MenuItem mi4 = new MenuItem("Acerca del juego");
		mi4.setOnAction(e->{
			aboveGame();
		});
		mb2.getItems().addAll(mi3, mi4);
		MenuBar mb = new MenuBar(mb1,mb2);
		h.getChildren().add(mb);
		v.getChildren().addAll(h,group);
		Scene sc = new Scene(v, 400,400);
		s.setScene(sc);
		s.show();
	}
	
	public void chargeGame() {
		//TODO
	}
	
	public void saveGame() {
		//TODO
	}
	
	public void showHall(){
		//TODO
	}
	
	public void aboveGame() {
		//TODO
	}
	
	public void stop(MouseEvent e) {
		game.stop(e);
	}
	
	public void winer() {
		Stage st = new Stage();
		VBox vb = new VBox(2);
		Text tx = new Text("FELICIDADES GANASTE Y CLASIFIASTE AL PODIUM");
		Text tx2 = new Text("INGRESA TU NOMBRE");
		TextField tf = new TextField();
		Button bt = new Button("listo");
		bt.setOnAction(e->{
			String name = tf.getText(); 
			game.addHall(name);
			
			
		});
		vb.getChildren().addAll(tx,tx2,tf,bt);
		Scene sc = new Scene(vb, 300,300);
		st.setScene(sc);
		st.show();
		
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
