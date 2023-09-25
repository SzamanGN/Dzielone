package okna;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

import panele.PanelGry;

public class OknoGry {
	private JFrame ramka;
	
	public OknoGry(PanelGry panelGry) {
		
		ramka = new JFrame();
		ramka.setDefaultCloseOperation(ramka.EXIT_ON_CLOSE);
		ramka.add(panelGry);
		ramka.pack();
		ramka.setLocationRelativeTo(null);
		ramka.addWindowFocusListener(new WindowFocusListener() {
			
			@Override
			public void windowLostFocus(WindowEvent e) {
				panelGry.getGra().windowFocusLost();
				
			}
			
			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ramka.setVisible(true);
		
	}

}
