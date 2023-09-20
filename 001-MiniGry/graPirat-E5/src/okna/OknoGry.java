package okna;

import javax.swing.JFrame;

public class OknoGry {
	private JFrame ramka;
	
	public OknoGry() {
		
		ramka =  new JFrame();
		ramka.setDefaultCloseOperation(ramka.EXIT_ON_CLOSE);
		
		ramka.pack();
		ramka.setLocationRelativeTo(null);
		ramka.setVisible(true);
		
	}

}
