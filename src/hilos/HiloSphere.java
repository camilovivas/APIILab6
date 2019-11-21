package hilos;

import model.Sphere;

public class HiloSphere extends Thread{
	private Sphere sphere;
	
	public HiloSphere(Sphere s) {
		this.sphere = s;
	}
	
	public void run() {
		while(true) {
			if(sphere.getStop()== true) {
				extracted();
			}
			sphere.moveHorizontal(sphere.getCircle());			
			sphere.moveVertical(sphere.getCircle());			
			try {
				sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void extracted() {
		stop();
	}
	
	

}
