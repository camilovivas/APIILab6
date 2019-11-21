package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Sphere {
	private Circle circle;
	private int x;
	private int y;
	private int diametro;
	private GraphicsContext gc;
	
	public Sphere(int x, int y, int diametro, Paint p) {
		circle = new Circle(x,y,diametro, p);
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

	


	public Circle getCircle() {
		return circle;
	}



	public void move(Circle circle1) {
		if( circle1.getLayoutX() == 400) {
			x = 1;
		}
		if(circle1.getLayoutX() == 0) {
			x = 0;
		}
		if(x == 1) {
//			circle.setLayoutX(circle.getLayoutX()-10);
			circle1.setCenterX(circle1.getCenterX()-10);
		}
		if(x == 0) {
//			circle.setLayoutX(circle.getLayoutX()+10);
			circle1.setCenterX(circle1.getCenterX()+10);
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
