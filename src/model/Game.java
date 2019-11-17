package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javafx.scene.canvas.GraphicsContext;

public class Game {
	private int level;
	private ControllerHall hall;
	private GraphicsContext gc;
	

	
	public Game(int level,  GraphicsContext gc) {
		this.level = level;
		hall = new ControllerHall();
		this.gc = gc;
		initialize();
		
	
	}


	public void initialize() {
		if(level == 1) {
			Sphere sphere1 = new Sphere(20,20,  20,  gc);
			sphere1.move();
			
		}
		if(level == 2) {
			
		}
		if(level == 3) {
			
		}
	}
	
	public void saveGame() {
		try {
			FileOutputStream fo = new FileOutputStream(new File(""));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
		
}
