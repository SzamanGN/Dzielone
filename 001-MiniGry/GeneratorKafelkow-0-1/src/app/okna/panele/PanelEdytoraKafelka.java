package app.okna.panele;

import javax.swing.JPanel;

import app.modele.Kafelek;
import app.pomoce.Kolor;

import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class PanelEdytoraKafelka extends JPanel {
	
	private Point piksel;
	private int rozmiar;
	private int kolorTuszu;
	private Kafelek kafelek;

	public PanelEdytoraKafelka() {
		setBackground(Color.WHITE);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				piksel.x = e.getX() / rozmiar;
				piksel.y = e.getY() / rozmiar;
				repaint();
			}
		});
		piksel = new Point(0, 0);
		rozmiar = 10;
		kolorTuszu = 1;
		kafelek = new Kafelek(32, 32, 10);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Rysowanie kafelka
		g.drawImage(
				kafelek.get(),
				0,
				0,
				null
				);
		
		// zaznaczanie piksela
		g.setColor(Kolor.get(kolorTuszu));
		g.fillRect(
				piksel.x * rozmiar, 
				piksel.y * rozmiar, 
				rozmiar, 
				rozmiar);
	}

	public void ustawKolorTuszu(int kolorTuszu) {
		this.kolorTuszu = kolorTuszu;
		repaint();
	}

	public void setPixel(int x, int y, int kolor) {
		kafelek.setPixel(x, y, kolor);
		repaint();
	}
	
	

}
