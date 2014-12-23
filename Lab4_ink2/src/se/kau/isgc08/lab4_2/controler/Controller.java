package se.kau.isgc08.lab4_2.controler;
import java.awt.Color;
import se.kau.isgc08.lab4_2.model.DrawingManager;
import se.kau.isgc08.lab4_2.view.SwingView;

public class Controller {
	
	private SwingView sv;
	private DrawingManager dm;
	private final static String STATE_OPT_1 = "NEW", STATE_OPT_2 = "EDIT";
	private final static String SHAPE_OPT_1 = "CIRCLE", SHAPE_OPT_2 = "SQUARE", SHAPE_OPT_3 = "LINE"; // TODO ändra variabel till stora bokstäver
	private int width, height;
	
	public Controller() {
		sv = new SwingView(this);
		dm = new DrawingManager(sv.getDrawUtil());
		sv.drawGUI(dm.getContainer());
	}

	public void handleColorFill(Color chosenColorFill) {
		dm.setColorFill(chosenColorFill);
	}

	public void handleColorOutline(Color chosenColorOutline) {
		dm.setColorOutline(chosenColorOutline);
	}

	public void handleExit() {
		System.exit(0);
	}

	public void relaySlide(int value) {
		dm.setLineThickness(value);
	}

	public void handleStateOption(String selState) {
		String selectedState;
		if (selState.equals("Måla ny")) {
			sv.enableEditingOptions();
			selectedState = STATE_OPT_1;
		}
		else {
			sv.disableEditingOptions();
			selectedState = STATE_OPT_2;
		}
		dm.setStateOption(selectedState);
	}

	public void handleShapeOption(String selShape) {
		String selectedShape;
		if (selShape.equals("Cirkel")) {
			selectedShape = SHAPE_OPT_1 ;
			sv.enableColorOutline();
		}
		else if (selShape.equals("Fyrkant")) {
			selectedShape = SHAPE_OPT_2;
			sv.enableColorOutline();
		}
		else {
			selectedShape = SHAPE_OPT_3;
			sv.disableColorOutline();
		}
		dm.setShapeOption(selectedShape);
	}

	public void handleMousePressed(int xStart, int yStart) {
		
		if (dm.getStateOption().equals(STATE_OPT_1))
		{
			dm.setStartCoordinates(xStart, yStart);
		}
		else {
			//kolla om det finns något på dessa koordinater.
		}
	}
	public void handleMouseReleased(int xEnd, int yEnd) {
		System.out.println("handleMouseReleased.");
		if (dm.getStateOption().equals(STATE_OPT_1)) {
			drawNewShape(xEnd, yEnd);
		}
		else {
			editOldShape();
		}	
	}

	private void editOldShape() {
		// TODO // ändra storlek eller ta bort eller nåt.
	}

	private void drawNewShape(int xEnd, int yEnd) {
		System.out.println("drawNewShape.");
		int tmp, xStartCurrent, yStartCurrent;
		
		switch (dm.getShapeOption()) {
		case SHAPE_OPT_1: // Cirkel
			System.out.println("Cirkel");
			
			xStartCurrent = dm.getStartCoordinateX();
			yStartCurrent = dm.getStartCoordinateY();
			
			if (xEnd > xStartCurrent) {
				width = xEnd - xStartCurrent;
			}
			if (xEnd < xStartCurrent) {
				width = xStartCurrent - xEnd;
				tmp = xStartCurrent;
				xStartCurrent = xEnd;
				xEnd = tmp;
			}
			if (yEnd > yStartCurrent) {
				height = yEnd - yStartCurrent;
				
			}
			if (yEnd < yStartCurrent) {
				height = yStartCurrent - yEnd;
				tmp = yStartCurrent;
				yStartCurrent = yEnd;
				yEnd = tmp;
			}
			dm.setStartCoordinates(xStartCurrent, yStartCurrent);
			dm.setEndCoordinates(xEnd, yEnd);
			dm.setWidthAndHeight(width, height);
			dm.drawCircle();
			break;
			
		case SHAPE_OPT_2: // Fyrkant
			System.out.println("Fyrkant");
			
			xStartCurrent = dm.getStartCoordinateX();
			yStartCurrent = dm.getStartCoordinateY();
			
			if (xEnd > xStartCurrent) {
				width = xEnd - xStartCurrent;
			}
			if (xEnd < xStartCurrent) {
				width = xStartCurrent - xEnd;
				tmp = xStartCurrent;
				xStartCurrent = xEnd;
				xEnd = tmp;
			}
			if (yEnd > yStartCurrent) {
				height = yEnd - yStartCurrent;
				
			}
			if (yEnd < yStartCurrent) {
				height = yStartCurrent - yEnd;
				tmp = yStartCurrent;
				yStartCurrent = yEnd;
				yEnd = tmp;
			}
			dm.setStartCoordinates(xStartCurrent, yStartCurrent);
			dm.setEndCoordinates(xEnd, yEnd);
			dm.setWidthAndHeight(width, height);
			dm.drawSquare();
			break;
			
		case SHAPE_OPT_3: // Linje
			dm.setEndCoordinates(xEnd, yEnd);
			dm.drawLine();
			break;
			
		default:
			break;
		} 
		sv.repaintGUI();
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
