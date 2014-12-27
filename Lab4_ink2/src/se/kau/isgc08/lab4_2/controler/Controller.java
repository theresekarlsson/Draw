package se.kau.isgc08.lab4_2.controler;
import java.awt.Color;
import se.kau.isgc08.lab4_2.model.DrawingManager;
import se.kau.isgc08.lab4_2.view.SwingView;

public class Controller {
	
	private SwingView sv;
	private DrawingManager dm;
	private final static String STATE_OPT_NEW = "NEW", STATE_OPT_EDIT = "EDIT";
	private final static String SHAPE_OPT_CIRCLE = "CIRCLE", SHAPE_OPT_SQUARE = "SQUARE", SHAPE_OPT_LINE = "LINE";	
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

	public void handleSlider(int value) {
		dm.setLineThickness(value);
	}

	public void handleStateOption(String selState) {
		String selectedState = null;
		switch (selState) {
		case "Måla ny":
			sv.enableEditingOptions();
			selectedState = STATE_OPT_NEW;
			break;
		case "Förändra befintlig":
			sv.disableEditingOptions();
			selectedState = STATE_OPT_EDIT;
			break;
		default:
			break;
		}
		dm.setStateOption(selectedState);
	}

	public void handleShapeOption(String selShape) {
		String selectedShape = null;
		switch (selShape) {
		case "Cirkel":
			selectedShape = SHAPE_OPT_CIRCLE ;
			sv.enableColorOutline();
			break;
		case "Fyrkant":
			selectedShape = SHAPE_OPT_SQUARE;
			sv.enableColorOutline();
			break;
		case "Linje":
			selectedShape = SHAPE_OPT_LINE;
			sv.disableColorOutline();
			break;
		default:
			break;
		}
		dm.setShapeOption(selectedShape);
	}

	public void handleMousePressed(int xStart, int yStart) {
		switch (dm.getStateOption()) {
		case STATE_OPT_NEW:
			dm.setStartCoordinates(xStart, yStart);
			break;
		case STATE_OPT_EDIT:
			System.out.println("STATE EDIT");
			int xCheck = xStart;
			int yCheck = yStart;
			dm.checkTheCoordinates(xCheck, yCheck);
			break;
		default:
			break;
		}
	}
	public void handleMouseReleased(int xEnd, int yEnd) {
		System.out.println("handleMouseReleased.");

		switch (dm.getStateOption()) {
		case STATE_OPT_NEW:
			if (dm.getStartCoordinateX() != xEnd && dm.getStartCoordinateY() != yEnd) {
				drawNewShape(xEnd, yEnd);
			}
			break;
		case STATE_OPT_EDIT:
			
			//editOldShape();
			
			break;
		default:
			break;
		}
	}

	private void editOldShape() {
		// TODO // ändra storlek eller ta bort eller nåt.
	}

	private void drawNewShape(int xEnd, int yEnd) {
		System.out.println("drawNewShape.");
		int tmp, xStartCurrent, yStartCurrent;
		
		switch (dm.getShapeOption()) {
		case SHAPE_OPT_CIRCLE: // Cirkel
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
			
		case SHAPE_OPT_SQUARE: // Fyrkant
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
			
		case SHAPE_OPT_LINE: // Linje
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
