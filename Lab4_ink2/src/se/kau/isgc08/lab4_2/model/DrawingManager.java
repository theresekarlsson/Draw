package se.kau.isgc08.lab4_2.model;
import java.awt.Color;
import se.kau.isgc08.lab4_2.view.DrawingUtil;

public class DrawingManager {
  
	private DrawingContainer drawContainer;
	private FileHandler fh;
	private int lineThickness = 1;
	private String shapeDefault = "CIRCLE";
	private String stateDefault = "NEW";
	private String currentState = stateDefault;
	private String currentShape = shapeDefault;
	private Color currentColorOutline = null;
	private Color currentColorFill = null;
	private DrawingUtil drawUtil;
	private int startPosX, startPosY, endPosX, endPosY, width, height;
	
	public DrawingManager(DrawingUtil drawingUtil) {

		drawUtil = drawingUtil;
		fh = new FileHandler();
		drawContainer = new DrawingContainer();
		drawContainer = fh.openFromFile();
	}
	
	public DrawingContainer getContainer() {
		return drawContainer;
	}
	
	public void drawCircle() {
		System.out.println("Inne i drawCircle ");
		Circle circle = new Circle(drawUtil, startPosX, startPosY, width, height, lineThickness, currentColorOutline, currentColorFill);
		drawContainer.add(circle);
		fh.saveToFile(drawContainer);
	}

	public void drawSquare() {
		System.out.println("Inne i drawCircle ");
		Rect rectangle = new Rect(drawUtil, startPosX, startPosY, width, height, lineThickness, currentColorOutline, currentColorFill);
		drawContainer.add(rectangle);
		fh.saveToFile(drawContainer);
	}
	
	public void drawLine() {
		System.out.println("Inne i drawLine");
		Line line = new Line(drawUtil, startPosX, startPosY, endPosX, endPosY, lineThickness, currentColorFill);
		drawContainer.add(line);
		fh.saveToFile(drawContainer);
	}
	
	public void setStateOption(String selectedState) {
		currentState = selectedState;
		System.out.println("State: " + currentState);
	}

	public String getStateOption() {
		return currentState;
	}

	public void setShapeOption(String selectedShape) {
		currentShape = selectedShape;
		System.out.println("Sätt shape: " + currentShape);
	}
	public String getShapeOption() {
		System.out.println("Returnera shape: " + currentShape);
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
		System.out.println("Linjetjocklek: " + lineThickness);
	}
	
	public void setColorFill(Color chosenColorFill) {
		currentColorFill = chosenColorFill;
		System.out.println("Fyllnadsfärg: " + currentColorFill.toString());
	}

	public void setColorOutline(Color chosenColorOutline) {
		currentColorOutline = chosenColorOutline;
		System.out.println("Linjefärg: " + currentColorOutline.toString());
	}
}
