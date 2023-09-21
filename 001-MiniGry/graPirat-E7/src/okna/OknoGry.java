package okna;

import javax.swing.JFrame;

import panele.PanelGry;

public class OknoGry {
	private JFrame ramka;
	
	public OknoGry(PanelGry panelGry) {
		
		ramka =  new JFrame();
		ramka.setDefaultCloseOperation(ramka.EXIT_ON_CLOSE);
		ramka.add(panelGry);
		ramka.pack();
		ramka.setLocationRelativeTo(null);
		ramka.setVisible(true);
		
	}

}
