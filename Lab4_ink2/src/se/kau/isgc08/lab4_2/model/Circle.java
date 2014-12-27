package se.kau.isgc08.lab4_2.model;

import java.awt.Color;
import java.awt.Graphics;

import se.kau.isgc08.lab4_2.view.DrawingUtilInterface;

public class Circle extends DrawingShape {

	private static final long serialVersionUID = 1L;

	public void draw(Graphics g) {
		di.drawCircle(this,g);
	}
	
	public Circle(DrawingUtilInterface di,int x1, int y1, int w, int h, int width, Color lineColor, Color area) {
		super(di);
		setX1(x1);
		setWidth(w);
		setY1(y1);
		setHeight(h);
		setLineWidth(width);
		setLineColor(lineColor);
		setAreaColor(area);
	}
	
	public DrawingShape checkCoordinates(int xCheck, int yCheck) {
		int x2 = getX1() + getWidth();
		int y2 = getY1() + getWidth();
		if ((xCheck > getX1() && xCheck < x2) && (yCheck > getY1() && yCheck < y2)) {
			System.out.println("Cirkelns koordinater. x1: " + getX1() + ", x2: " + x2 + ", y1: " + getY1() + ", y2: " + y2 );
			System.out.println("Cirkel");
		}
		return this;
	}
}
