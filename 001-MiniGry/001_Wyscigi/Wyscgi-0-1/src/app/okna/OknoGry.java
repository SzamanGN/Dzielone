package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panele.PanelGry;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OknoGry extends JFrame {

	private PanelGry panelGry;

	public OknoGry() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_RIGHT:
						// ruch w prawo
						panelGry.ustawRuchGraczaWPrawo();
						break;
					case KeyEvent.VK_LEFT:
						// ruch w lewo
						panelGry.ustawRuchGraczaWLewo();
						break;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_ESCAPE:
						// wyjscie z gry
						wyjscieZGry();
						break;
					case KeyEvent.VK_B:
						// wybor gracza B
						panelGry.zmienGracza("Bartek");
						break;
					case KeyEvent.VK_O:
						// wybor gracza O
						panelGry.zmienGracza("Oli");
						break;
						// usuniecie ruchu gracza
						
					case KeyEvent.VK_RIGHT:
						// ruch w prawo zakoncz
						panelGry.zakonczRuchGracz();
						break;
					case KeyEvent.VK_LEFT:
						// ruch w lewo zakoncz
						panelGry.zakonczRuchGracz();
						break;
				}
			}
		});
		setUndecorated(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelGry = new PanelGry();
		setContentPane(panelGry);
		setVisible(true);
	}
	
	private void wyjscieZGry() {
		System.err.println("Wyjscie z gry");
		System.exit(0);
	}

}
