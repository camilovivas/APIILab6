package hilos;

import application.Main;
import model.Sphere;

public class HiloSphere extends Thread{
	private Sphere sphere;
	
	public HiloSphere(Main m, Sphere s) {
		this.sphere = s;
	}
	
	public void run() {
		mover();
	}
	
	public void mover() {
		
	}

}
