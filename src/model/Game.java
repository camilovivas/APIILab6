package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
			showLevel1();
			threadLevel1();
		}
		if(level == 2) {
			initLevel2();
			showLevel2();
			threadLevel2();
			
		}
		if(level == 3) {
			initLevel3();
			showLevel3();
			threadLevel3();
		}
	}
	
//	LEVEL1
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
		
	}
	
	public void showLevel1() {		
		for (int i = 0; i < level1.length; i++) {
			group.getChildren().add(level1[i].getCircle());			
		}
	}
	
	public void threadLevel1() {
		for (int i = 0; i < level1.length; i++) {			
			HiloSphere hs = new HiloSphere(level1[i]);
			hs.start();
		}		
	}
	
//	LEVEL2
	public void initLevel2() {
		initLevel1();
		level2 = new Sphere[SPHERES_LEVEL2];
		for (int i = 0; i < level1.length; i++) {
			level2[i] = level1[i];
		}
		level2[4] = new Sphere(80,80,19, Color.BROWN);
		level2[5] = new Sphere(90,150,30, Color.BLUEVIOLET);
		
	}
	
	public void showLevel2() {		
		for (int i = 0; i < level2.length; i++) {
			group.getChildren().add(level2[i].getCircle());			
		}
	}
	
	public void threadLevel2() {
		for (int i = 0; i < level2.length; i++) {			
			HiloSphere hs = new HiloSphere(level2[i]);
			hs.start();
		}		
	}
	
//	LEVEL3
	public void initLevel3() {
		initLevel2();
		level3 = new Sphere[SPHERES_LEVEL3];
		for (int i = 0; i < level2.length; i++) {
			level3[i] = level2[i];
		}
		level3[6] = new Sphere(70,165,12, Color.DARKGREY);
		level3[7] = new Sphere(200,100,23, Color.CYAN);
		
	}
	public void showLevel3() {		
		for (int i = 0; i < level3.length; i++) {
			group.getChildren().add(level3[i].getCircle());			
		}
	}
	
	public void threadLevel3() {
		for (int i = 0; i < level3.length; i++) {			
			HiloSphere hs = new HiloSphere(level3[i]);
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
