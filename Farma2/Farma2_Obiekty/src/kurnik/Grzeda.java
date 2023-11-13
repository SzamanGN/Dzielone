package kurnik;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.border.EmptyBorder;

public class Grzeda extends JPanel {

	private static final long serialVersionUID = 1L;

	
	public Grzeda() {
		ustaw(0, null);
	}
	
	public Grzeda(int ktoryPanel, MouseAdapter mouseAdapter) {
		ustaw(ktoryPanel, mouseAdapter);
	}
	
	public void ustaw(int ktoryPanel, MouseAdapter mouseAdapter) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(0, 6, 5, 5));
		
		add(new PanelKogut(100, 4));
//		for(int i = 0; i < 5; i++) {
//			add(new PanelKury());
//		}
		
		for(int i = 1; i <= 5; i++) {
			add(new PanelKury(-1, 5, 4, ktoryPanel, i, mouseAdapter));
		}
		
	}

	public boolean isJajo(int indeksKury, int indeksJajka) {
		return ((PanelKury) this.getComponent(indeksKury)).isJajko(indeksJajka);
	}

	public void usunJajo(int indeksKury, int indeksJajka) {
		((PanelKury) this.getComponent(indeksKury)).usunJajko(indeksJajka);
	}

}
