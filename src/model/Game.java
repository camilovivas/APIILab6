package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import hilos.HiloSphere;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Game {
	public static int SPHERES_LEVEL1 = 4;
	public static int SPHERES_LEVEL2 = 6;
	public static int SPHERES_LEVEL3 = 8;
	private int level;
	private ControllerHall hall;
	private Group group;
	private Sphere [] level1;
	private Sphere [] level2;
	private Sphere [] level3;
	
	public Game(int level, Group group) {
		this.level = level;
		this.group= group;
		hall = new ControllerHall();
		initialize();
		
	
	}


	public void initialize() {
		if(level == 1) {
			initLevel1();
		}
		if(level == 2) {
			
		}
		if(level == 3) {
			
		}
	}
	
	public void initLevel1() {
		level1 = new Sphere[SPHERES_LEVEL1];
		Sphere sphere0 = new Sphere(20,20,20, Color.DARKGREEN);
		level1[0] = sphere0;
		Sphere sphere1 = new Sphere(0,80,30, Color.RED);
		level1[1] = sphere1;
		Sphere sphere2 = new Sphere(20, 200,20, Color.YELLOW);
		level1[2] = sphere2;
		Sphere sphere3 = new Sphere(200,200,15, Color.BLUE);
		level1[3] = sphere3;
		
		for (int i = 0; i < level1.length; i++) {
			group.getChildren().add(level1[i].getCircle());			
		}
		for (int i = 0; i < level1.length; i++) {			
			HiloSphere hs = new HiloSphere(level1[i]);
			hs.start();
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
