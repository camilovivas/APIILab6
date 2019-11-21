package model;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Sphere implements Serializable {
	private Circle circle;
	private int x;
	private int y;
	private int diametro;
	private boolean stop;
	
	public Sphere(int x, int y, int diametro, Paint p) {
		circle = new Circle(x,y,diametro, p);
		this.diametro = diametro;
		this.stop=false;
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



	public void moveHorizontal(Circle circle1) {
		if( circle1.getCenterX() == 400) {
			x = 1;
		}
		if(circle1.getCenterX() == 0) {
			x = 0;
		}
		if(x == 1) {
			circle1.setCenterX(circle1.getCenterX()-10);
		}
		if(x == 0) {
			circle1.setCenterX(circle1.getCenterX()+10);
		}
		
	}
	
	public void moveVertical(Circle circle1) {
		int z = 0;
		if(circle1.getCenterY()==0) {
			z = 2;
		}
		if(circle1.getCenterY()==400) {
			z =3;
		}
		if( circle1.getCenterX() == 400) {
			y = 1;
		}
		if(circle1.getCenterX() == 0) {
			y = 0;
		}
		if(y == 1 || z ==2) {
			circle1.setCenterY(circle1.getCenterY()-5);
		}
		if(y == 0 ||z ==3) {
			circle1.setCenterY(circle1.getCenterY()+5);
		}
	}
	
	public void stopSphere(MouseEvent  event) {
		double Mx = event.getX();
		double My = event.getY();
		double distan = Math.sqrt(((x-Mx)*(x-Mx))+((y-My)*(y-My)));
		System.out.println(distan);
		if(distan <= diametro) {
			this.stop= true;
		}
	}



	public boolean getStop() {
		// TODO Auto-generated method stub
		return stop;
	}

}
