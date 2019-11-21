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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Game;

public class Controller {
	private Game game;
	private Group group;
	
	public void aboveGame() {
		Stage st = new Stage();
		VBox p = new VBox();
		Text tx = new Text("juego desarrollado por Camilo Vivas, consta en darle click a cada bola hasta que todas se detengan");
		p.getChildren().add(tx);
		Scene sc = new Scene(p);
		st.setScene(sc);
		st.show();
	}

	public void chargeGame() {
		//TODO
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

	public void saveGame() {
		//TODO
	}

	public void showHall(){
		Stage st = new Stage();
		VBox vb = new VBox(2);
		HBox hb = new HBox();
		Text tx = new Text(game.namesHall1());
		Text tx1 = new Text(game.namesHall2());
		Text tx2 = new Text(game.namesHall3());
		hb.getChildren().addAll(tx,tx1,tx2);
		vb.getChildren().add(hb);
		
		Scene sc = new Scene(vb);
		st.setScene(sc);
		st.show();
	}

	public void stop(MouseEvent e) {
		game.stop(e);
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
						s.close();
						if(game.podium()== true) {
							winer();
						}
						else {
							winer2();
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

	public void winer() {
		Stage st = new Stage();
		VBox vb = new VBox(4);
		Text tx = new Text("FELICIDADES GANASTE Y CLASIFIASTE AL PODIUM");
		Text tx2 = new Text("INGRESA TU NOMBRE");
		TextField tf = new TextField();
		Button bt = new Button("listo");
		bt.setOnAction(e->{
			String name = tf.getText(); 
			game.addHall(name);
			welcome(st);
		});
		vb.getChildren().addAll(tx,tx2,tf,bt);
		Scene sc = new Scene(vb, 300,300);
		st.setScene(sc);
		st.show();
		
	}

	public void winer2() {
		Stage st = new Stage();
		VBox vb = new VBox();
		Text tx = new Text("FELICIDADES GANASTE");
		Button bt = new Button("salir");
		bt.setOnAction(e->{
			st.close();
		});
		Button bt2 = new Button("jugar otra vez");
		bt2.setOnAction(e->{
			welcome(st);
		});
		vb.getChildren().addAll(tx,bt,bt2);
		Scene sc = new Scene(vb, 300,300);
		st.setScene(sc);
		st.show();
	}
}
