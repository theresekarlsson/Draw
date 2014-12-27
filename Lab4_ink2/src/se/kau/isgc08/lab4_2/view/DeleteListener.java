package se.kau.isgc08.lab4_2.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {

	SwingView sv;
	
	public DeleteListener(SwingView swingView) {
		sv = swingView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		sv.relayDelete();
	}
}
