package obrazki.kurnik;

import java.awt.Dimension;

import javax.swing.JPanel;

import okna.panele.PanelKurnikGrzeda;

public class PanelKurnik extends JPanel {

	
	public PanelKurnik() {
		
		setPreferredSize(new Dimension(1200, 600));
		add(new PanelKurnikGrzeda());
	}

}
