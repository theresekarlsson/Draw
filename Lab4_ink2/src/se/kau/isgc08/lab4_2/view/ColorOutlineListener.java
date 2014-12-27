package se.kau.isgc08.lab4_2.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorOutlineListener implements ActionListener {

	private SwingView sv;
	
	public ColorOutlineListener(SwingView swingView) {
		sv = swingView;
	}

	public void actionPerformed(ActionEvent e) {
		sv.relayColorOutline();
	}
}
