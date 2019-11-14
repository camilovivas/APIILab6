package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Game {
	private int level;
	public static int QUANTITY_HALL = 10;
	private Hall[] famous;
	
	public Game(int level) {
		famous = new Hall[QUANTITY_HALL];
	}
	
	public void initialize() {
		if(level == 1) {
			
		}
		if(level == 2) {
			
		}
		if(level == 3) {
			
		}
	}
	
	
	public void addHall(String name, int score) {
		boolean stop = false;
		Hall h = new Hall(name, score);
		if(HallIsFull() == true) {
			famous[famous.length-1] = null;
		}
		for (int i = 0; i < famous.length && !stop; i++) {
			if(famous[i] == null) {
					famous[i]= h;
					organizeHall();
			}
		}
	}
	
	public void organizeHall() {
		for (int i = 1; i < famous.length; i++) {
			for (int j = i; j > 0; j--) {
				int com = famous[j-1].compareTo(famous[j]);
				if(com == 1) {
					Hall temp = famous[j];
					famous[j] = famous[j-1];
					famous[j-1] = temp;
				}
			}
		}
	}
	
	public boolean HallIsFull() {
		return (famous[famous.length] !=  null);
	}
	
	public void saveHall() {
		try {
			FileOutputStream file = new FileOutputStream("files/Hall.arc");
			ObjectOutputStream object = new ObjectOutputStream(file);
			object.writeObject(famous);
			object.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readHall() {
		try {
			FileInputStream f = new FileInputStream(new File("files/Hall.arc"));
			ObjectInputStream object = new ObjectInputStream(f);
			famous = (Hall[]) object.readObject();
			object.close();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
