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
	
	// TODO Nåt knas här!!
	public DrawingShape checkCoordinatesForShape(int xCheck, int yCheck) {
		
		if ((xCheck > x1 && xCheck < width) && (yCheck > y1 && yCheck < height)) {
			System.out.println("Här är en linje");
			return this;
		}
		else {
			return null;
		}
	}
}
