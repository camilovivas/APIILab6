package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Sphere {
	
	private int x;
	private int y;
	private int diametro;
	private GraphicsContext gc;
	
	public Sphere(int x, int y, int diametro, GraphicsContext gc) {
		this.gc = gc;
		this.diametro = diametro;
	}
	
	
	
	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public void move() {
		while(true) {
			if(x <= 300 ) {
				x =+ 10; 
			}
			
//			gc.fillOval(x, y, 20, 20);
		}
	}
	public void Stop(MouseEvent  event) {
		double Mx = event.getX();
		double My = event.getY();
		double distan = Math.sqrt(((Mx-x)*(Mx-x))+((My-y)*(My-y)));
		if(distan <= diametro) {
			
		}
	}

}
