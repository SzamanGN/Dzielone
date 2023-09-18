package app.okna;

import javax.swing.JFrame;

import app.panele.PanelGry;

public class OknoGry {
	private JFrame jframe;
	private PanelGry panelGry;
	
	public OknoGry(PanelGry panelGry) {
		
		jframe = new JFrame();
		
		jframe.setTitle("Gra Pirat-0-1");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(panelGry);
		jframe.pack();
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}

}
