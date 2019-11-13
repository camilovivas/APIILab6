package model;

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
		for (int i = 0; i < famous.length && !stop; i++) {
			if(famous[i] != null) {
				if(famous[i].getScore()> h.getScore()) {
					
				}
			}
			else {
				famous[i] = h;				
			}
		}
	}
	
}
