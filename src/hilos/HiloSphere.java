package hilos;

import application.Main;
import model.Sphere;

public class HiloSphere extends Thread{
	private Sphere sphere;
	
	public HiloSphere(Sphere s) {
		this.sphere = s;
	}
	
	public void run() {
		while(true) {
			sphere.move(sphere.getCircle());
			
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
