package panele;

import javax.swing.JPanel;

import aktorzy.Gracz;
import aktorzy.Przeciwnik;
import menagery.MenagerStrzal;

import java.awt.Color;
import java.awt.Graphics;

public class PanelPolaBitwy extends JPanel {

	private static final long serialVersionUID = 1L;
	private Gracz gracz;
	private Przeciwnik przeciwnik;
	private MenagerStrzal mengerStrzal;
	
	public PanelPolaBitwy() {
		setBackground(new Color(0, 0, 0));
		incijowanieDanych();

	}

	private void incijowanieDanych() {
		gracz = new Gracz(50, 150, 50, 300, Color.BLUE, 100);
		przeciwnik = new Przeciwnik(700, 150, 50, 300, Color.RED, 100);
		mengerStrzal = new MenagerStrzal();
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		rysowanie(g);
	}

	private void rysowanie(Graphics g) {
		gracz.rysowanie(g);
		przeciwnik.rysowanie(g);
		mengerStrzal.rysowanie(g);
	}

	public void tikZegara() {
		gracz.tikZegara();
		przeciwnik.tikZegara();
		aktulizacjaSytuacji();
		repaint();
	}

	private void aktulizacjaSytuacji() {
		mengerStrzal.tikZegara();
		// sprawdzenie czy gracz strzela 
		if(gracz.isStrzela()) {
			System.out.println("Gracz strzela");
			mengerStrzal.add(gracz.strzal());
		}
		// sprawdzenie przeciwnika
		if(przeciwnik.isStrzela()) {
			System.out.println("Przeciwnik strzela");
		}
	}

	public void aktualizacjaZyciaGracza(int delta) {
		gracz.aktualizacjaZycia(delta);
	}

	public void aktualizacjaZyciaPrzeciwnika(int delta) {
		przeciwnik.aktualizacjaZycia(delta);
	}
	
}
