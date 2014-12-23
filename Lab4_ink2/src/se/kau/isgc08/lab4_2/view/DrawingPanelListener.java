package se.kau.isgc08.lab4_2.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawingPanelListener implements MouseListener {

	SwingView sv;
	
	public DrawingPanelListener(SwingView swingView) {
		sv = swingView;
	}

	public void mousePressed(MouseEvent e) {
		int xStart, yStart; 
		xStart = e.getX();     
		yStart = e.getY();
		sv.relayMousePressed(xStart, yStart);
	}

	public void mouseReleased(MouseEvent e) {
		int xEnd, yEnd;
		xEnd = e.getX();
		yEnd = e.getY();
		sv.relayMouseReleased(xEnd, yEnd);
	}
	
	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}
}
