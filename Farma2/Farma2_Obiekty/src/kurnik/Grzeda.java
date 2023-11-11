package kurnik;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

public class Grzeda extends JPanel {

	private static final long serialVersionUID = 1L;

	public Grzeda() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(0, 6, 5, 5));
		
		add(new PanelKogut(100, 4));
//		for(int i = 0; i < 5; i++) {
//			add(new PanelKury());
//		}
		
		
		add(new PanelKury());
		add(new PanelKury(100, 5, 4));
	}

}
