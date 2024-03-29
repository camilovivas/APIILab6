package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ControllerHall {
	
	public static int QUANTITY_HALL = 10;
	private Hall[] famous1;
	private Hall[] famous2;
	private Hall[] famous3;
	
	public ControllerHall() {
		famous1 = new Hall[QUANTITY_HALL];
		famous2 = new Hall[QUANTITY_HALL];
		famous3 = new Hall[QUANTITY_HALL];
	}
	
//	METHODS LEVEL 1
	public boolean clasificaLevel1(double time) {
		boolean retorno = false;
		for (int i = 0; i < famous1.length && !retorno; i++) {
			if(famous1[i]!= null){
				if(famous1[i].getScore() > time) {
					retorno = true;
				}
			}
			else {
				retorno = true;
			}
		}
		return retorno;
	}
	
	public void addHallLevel1(String name, double score) {
		boolean stop = false;
		Hall h = new Hall(name, score);
		if(HallLevel1IsFull() == true) {
			famous1[famous1.length-1] = null;
		}
		for (int i = 0; i < famous1.length && !stop; i++) {
			if(famous1[i] == null) {
					famous1[i]= h;
					organizeHall();
					saveHalllevel1();
			}
		}
	}
	
	public void organizeHall() {
		for (int i = 1; i < famous1.length; i++) {
			for (int j = i; j > 0; j--) {
				if(famous1[j-1] !=null && famous1[j] != null ) {
					int com = famous1[j-1].compareTo(famous1[j]);
					if(com == 1) {
						Hall temp = famous1[j];
						famous1[j] = famous1[j-1];
						famous1[j-1] = temp;
					}
				}
			}
		}
	}
	
	public boolean HallLevel1IsFull() {
		return (famous1[famous1.length-1] !=  null);
	}
	
	public void saveHalllevel1() {
		try {
			FileOutputStream file = new FileOutputStream("files/Hall.arc");
			ObjectOutputStream object = new ObjectOutputStream(file);
			object.writeObject(famous1);
			object.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readHalllevel1() {
		try {
			FileInputStream f = new FileInputStream(new File("files/Hall.arc"));
			ObjectInputStream object = new ObjectInputStream(f);
			famous1 = (Hall[]) object.readObject();
			object.close();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
//	METHODS LEVEL 2
	public boolean clasificaLevel2(double time) {
		boolean retorno = false;
		for (int i = 0; i < famous2.length && !retorno; i++) {
			if(famous2[i]!= null){
				if(famous2[i].getScore() > time) {
					retorno = true;
				}
			}
			else {
				retorno = true;
			}
		}
		return retorno;
	}
	public void addHallLevel2(String name, double score) {
		boolean stop = false;
		Hall h = new Hall(name, score);
		if(HallLevel1IsFull() == true) {
			famous1[famous2.length-1] = null;
		}
		for (int i = 0; i < famous2.length && !stop; i++) {
			if(famous2[i] == null) {
					famous2[i]= h;
					organizeHall();
					saveHalllevel2();
			}
		}
	}
	
	public void organizeHallLevel2() {
		for (int i = 1; i < famous2.length; i++) {
			for (int j = i; j > 0; j--) {
				if(famous2[j-1] !=null && famous2[j] != null ) {
				int com = famous2[j-1].compareTo(famous2[j]);
				if(com == 1) {
					Hall temp = famous2[j];
					famous2[j] = famous2[j-1];
					famous2[j-1] = temp;
				}
			}
			}
		}
	}
	
	public boolean HallLevel2IsFull() {
		return (famous2[famous2.length-1] !=  null);
	}
	
	public void saveHalllevel2() {
		try {
			FileOutputStream file = new FileOutputStream("files/Hall2.arc");
			ObjectOutputStream object = new ObjectOutputStream(file);
			object.writeObject(famous2);
			object.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readHalllevel2() {
		try {
			FileInputStream f = new FileInputStream(new File("files/Hall2.arc"));
			ObjectInputStream object = new ObjectInputStream(f);
			famous2 = (Hall[]) object.readObject();
			object.close();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
//	METHOODS LEVEL 3
	public boolean clasificaLevel3(double time) {
		boolean retorno = false;
		for (int i = 0; i < famous3.length && !retorno; i++) {
			if(famous3[i]!= null){
				if(famous3[i].getScore() > time) {
					retorno = true;
				}
			}
			else {
				retorno = true;
			}
		}
		return retorno;
	}
	
	public void addHallLevel3(String name, double score) {
		boolean stop = false;
		Hall h = new Hall(name, score);
		if(HallLevel1IsFull() == true) {
			famous3[famous3.length-1] = null;
		}
		for (int i = 0; i < famous3.length && !stop; i++) {
			if(famous3[i] == null) {
					famous3[i]= h;
					organizeHall();
					saveHalllevel3();
			}
		}
	}
	
	public void organizeHallLevel3() {
		for (int i = 1; i < famous3.length; i++) {
			for (int j = i; j > 0; j--) {
				if(famous1[j-1] !=null && famous1[j] != null ) {
				int com = famous3[j-1].compareTo(famous3[j]);
				if(com == 1) {
					Hall temp = famous3[j];
					famous3[j] = famous3[j-1];
					famous3[j-1] = temp;
				}
			}
			}
		}
	}
	
	public boolean HallLevel3IsFull() {
		return (famous3[famous3.length-1] !=  null);
	}
	
	public void saveHalllevel3() {
		try {
			FileOutputStream file = new FileOutputStream("files/Hall3.arc");
			ObjectOutputStream object = new ObjectOutputStream(file);
			object.writeObject(famous3);
			object.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readHalllevel3() {
		try {
			FileInputStream f = new FileInputStream(new File("files/Hall3.arc"));
			ObjectInputStream object = new ObjectInputStream(f);
			famous3 = (Hall[]) object.readObject();
			object.close();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public  void generalRead(int lvl) {
		if(lvl == 1) {
			readHalllevel1();
		}
		if(lvl == 2) {
			readHalllevel2();
		}
		if(lvl == 3) {
			readHalllevel3();
		}
	}
	
	public String person1() {
		String person = "";
		for (int i = 0; i < famous1.length; i++) {
			if(famous1[i]!=null) {
				person += "nombre =  "+famous1[i].getName()+" puntaje"+famous1[i].getScore()+"\n";				
			}
		}
		return person;
	}
	public String person2() {
		String person = "";
		for (int i = 0; i < famous2.length; i++) {
			if(famous2[i]!=null) {
				person += "nombre =  "+famous2[i].getName()+" puntaje"+famous2[i].getScore()+"\n";
			}
		}
		return person;
	}

	public String person3() {
		String person = "";
		for (int i = 0; i < famous3.length; i++) {
			if(famous3[i]!=null) {
				person += "nombre =  "+famous3[i].getName()+"  puntaje"+famous3[i].getScore()+"\n";
			}
		}	
		return person;
	}

}
