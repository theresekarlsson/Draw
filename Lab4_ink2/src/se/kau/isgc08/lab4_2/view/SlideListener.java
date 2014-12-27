package se.kau.isgc08.lab4_2.view;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SlideListener implements ChangeListener {

	SwingView sv;
	JSlider source;
	
	public SlideListener(SwingView swingView, JSlider slide) {
		sv = swingView;
		source = slide;
	}

	public void stateChanged(ChangeEvent e) {
		source = (JSlider) e.getSource();
		
		if (!source.getValueIsAdjusting()) {
	        int value = (int)source.getValue();
	        
	        sv.relaySlider(value);
	    }
	}

}
