package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import hilos.HiloSphere;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Game {
//	COSTANTES
	public static int SPHERES_LEVEL1 = 4;
	public static int SPHERES_LEVEL2 = 6;
	public static int SPHERES_LEVEL3 = 8;
	
//	ATRIBUTOS
	private int level;
	private ControllerHall hall;
	private Group group;
	private Sphere [] level1;
	private Sphere [] level2;
	private Sphere [] level3;
	private long timeStart;
	private double timeEnd;
	
	public Game(int level, Group group) {
		
		this.level = level;
		this.group= group;
		hall = new ControllerHall();
		hall.generalRead(level);
		initialize();
		timeStart = System.currentTimeMillis();
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
		Sphere sphere0 = new Sphere(20,20,20, Color.DARKGREEN, group);
		level1[0] = sphere0;
		Sphere sphere1 = new Sphere(0,80,30, Color.RED, group);
		level1[1] = sphere1;
		Sphere sphere2 = new Sphere(20, 200,20, Color.YELLOW, group);
		level1[2] = sphere2;
		Sphere sphere3 = new Sphere(200,200,15, Color.BLUE, group);
		level1[3] = sphere3;
		
	}
	
	public void showLevel1() {		
		for (int i = 0; i < level1.length; i++) {
			group.getChildren().add(level1[i].getCircle());			
		}
	}
	
	public void threadLevel1() {
		HiloSphere hs = new HiloSphere(level1[0]);
		HiloSphere hs2 = new HiloSphere(level1[1]);
		HiloSphere hs3 = new HiloSphere(level1[2]);
		HiloSphere hs4 = new HiloSphere(level1[3]);
		hs.start();
		hs2.start();
		hs3.start();
		hs4.start();		
	}
	
//	LEVEL2
	public void initLevel2() {
		initLevel1();
		level2 = new Sphere[SPHERES_LEVEL2];
		for (int i = 0; i < level1.length; i++) {
			level2[i] = level1[i];
		}
		level2[4] = new Sphere(80,80,19, Color.BROWN, group);
		level2[5] = new Sphere(90,150,30, Color.BLUEVIOLET, group);
		
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
		level3[6] = new Sphere(70,165,12, Color.DARKGREY, group);
		level3[7] = new Sphere(200,100,23, Color.CYAN, group);
		
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
	
	public void stop(MouseEvent e) {
		if(level == 1) {
			for (int i = 0; i < level1.length; i++) {
				if(level1[i].getStop() == false) {
					level1[i].stopSphere(e);
				}
			}
			
		}
		if(level == 2) {
			for (int i = 0; i < level2.length; i++) {
				if(level2[i].getStop() == false) {
					level2[i].stopSphere(e);
				}
			}
		}
		if(level == 3) {
			for (int i = 0; i < level3.length; i++) {
				if(level3[i].getStop() == false) {
					level3[i].stopSphere(e);
				}
			}
		}
	}
	
	public void setTimeEnd(double timeEnd) {
		this.timeEnd = timeEnd;
	}


	public boolean winner() {
		boolean retorno = false;
		int contador =0;
		if(level == 1) {
			for (int i = 0; i < level1.length; i++) {
				if(level1[i].getStop() == true) {
					contador++;
				}
			}
			if(contador == level1.length) {
				retorno = true;
				setTimeEnd(timeWin());
			}
		}
		if(level == 2) {
			for (int i = 0; i < level2.length; i++) {
				if(level2[i].getStop() == true) {
					contador++;
				}
			}
			if(contador == level2.length) {
				retorno = true;
				setTimeEnd(timeWin());
			}
		}
		if(level == 3) {
			for (int i = 0; i < level3.length; i++) {
				if(level3[i].getStop() == true) {
					contador++;
				}
			}
			if(contador == level3.length) {
				retorno = true;
				setTimeEnd(timeWin());
			}
		}
		return retorno;
	}
	
	public double timeWin() {
		long fin = System.currentTimeMillis();
		double time =(double) (fin-timeStart)/1000;
		return time;
	}
	
	public boolean podium() {
		boolean retorno = false;
		if(level == 1) {
			if(hall.clasificaLevel1(timeEnd)== true) {
				retorno = true;
			}
		}
		if(level == 2) {
			if(hall.clasificaLevel2(timeEnd)== true) {
				retorno = true;
			}
		}
		if(level == 3) {
			if(hall.clasificaLevel3(timeEnd)== true) {
				retorno = true;
			}
		}
		return retorno;
	}
	
	public void addHall(String name) {
		if(level == 1) {
			hall.addHallLevel1(name, timeEnd);
		}
		if(level == 2) {
			hall.addHallLevel2(name, timeEnd);
		}
		if(level == 3) {
			hall.addHallLevel3(name, timeEnd);
		}
	}
	public void saveGame() {
		try {
			FileOutputStream fo = new FileOutputStream(new File(""));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public String namesHall1() {
		return hall.person1();
	}
	public String namesHall2() {
		return hall.person1();
	}
	public String namesHall3() {
		return hall.person1();
	}
	
	
		
}
