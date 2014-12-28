package se.kau.isgc08.lab4_2.model;
import java.awt.Color;

import se.kau.isgc08.lab4_2.view.DrawingUtil;

public class DrawingManager {
  
	private DrawingContainer drawContainer;
	private FileHandler fh;
	private int lineThickness = 0;
	private String shapeDefault = "CIRCLE";
	private String stateDefault = "NEW";
	private String currentState = stateDefault;
	private String currentShape = shapeDefault;
	private Color currentColorOutline = null;
	private Color currentColorFill = null;
	private DrawingUtil drawUtil;
	private int startPosX, startPosY, endPosX, endPosY, width, height, yCheck, xCheck;
	
	public DrawingManager(DrawingUtil drawingUtil) {
		drawUtil = drawingUtil;
		fh = new FileHandler();
		drawContainer = new DrawingContainer();	
	}
	
	public DrawingContainer getContainer() {
		drawContainer = fh.openFromFile(drawContainer);
		return drawContainer;
	}
	
	public void drawCircle() {
		Circle circle = new Circle(drawUtil, startPosX, startPosY, width, height, lineThickness, currentColorOutline, currentColorFill);
		drawContainer.add(circle);
		fh.saveToFile(drawContainer);
	}

	public void drawSquare() {
		Rect rectangle = new Rect(drawUtil, startPosX, startPosY, width, height, lineThickness, currentColorOutline, currentColorFill);
		drawContainer.add(rectangle);
		fh.saveToFile(drawContainer);
	}
	
	public void drawLine() {
		Line line = new Line(drawUtil, startPosX, startPosY, endPosX, endPosY, lineThickness, currentColorFill);
		drawContainer.add(line);
		fh.saveToFile(drawContainer);
	}
	
	public void setStateOption(String selectedState) {
		currentState = selectedState;
	}

	public String getStateOption() {
		return currentState;
	}

	public void setShapeOption(String selectedShape) {
		currentShape = selectedShape;
	}
	public String getShapeOption() {
		return currentShape;
	}
	
	public void setStartCoordinates(int xStart, int yStart) {
		startPosX = xStart;
		startPosY = yStart;
	}
	
	public int getStartCoordinateX() {
		return startPosX;
	}
	
	public int getStartCoordinateY() {
		return startPosY;
	}
	
	public void setWidthAndHeight(int w, int h) {
		width = w;
		height = h;
	}
	
	public void setEndCoordinates(int xEnd, int yEnd) {
		endPosX = xEnd;
		endPosY = yEnd;
	}
	
	public void setLineThickness(int value) {
		lineThickness = value;
	}
	
	public void setColorFill(Color chosenColorFill) {
		currentColorFill = chosenColorFill;
	}

	public void setColorOutline(Color chosenColorOutline) {
		currentColorOutline = chosenColorOutline;
	}
	public DrawingShape checkTheCoordinates() {
		DrawingShape ds = drawContainer.checkCoordinatesForShape(xCheck, yCheck);
		System.out.println(ds);
		return ds;
	}

	public void setEditCoordinates(int x, int y) {
		xCheck = x;
		yCheck = y;
	}
}
