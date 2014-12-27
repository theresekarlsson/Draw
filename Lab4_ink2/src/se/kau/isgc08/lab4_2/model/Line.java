package se.kau.isgc08.lab4_2.model;

import java.awt.Color;
import java.awt.Graphics;

import se.kau.isgc08.lab4_2.view.DrawingUtilInterface;

public class Line extends DrawingShape {

	private static final long serialVersionUID = 1L;

	public void draw(Graphics g) {
		di.drawLine(this, g);
	}
	
	public Line(DrawingUtilInterface di, int x1, int y1, int x2, int y2, int width, Color color) {
		super(di);
		setX1(x1);
		setWidth(x2);
		setY1(y1);
		setHeight(y2);
		setLineWidth(width);
		setLineColor(color);
		setAreaColor(Color.BLACK);
	}
	
	public DrawingShape checkCoordinates(int xCheck, int yCheck) {
		/*
		int x2 = getX1() + getWidth();
		int y2 = getY1() + getWidth();
		*/
		if ((xCheck > getX1() && xCheck < getWidth()) && (yCheck > getY1() && yCheck < getHeight())) {
			//System.out.println("Linjens koordinater. x1: " + getX1() + ", x2: " + x2 + ", y1: " + getY1() + ", y2: " + y2 );
			System.out.println("Linje");
		}
		return this;
	}
}
