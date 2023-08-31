package app.modele;

import java.awt.Graphics2D;
import java.awt.GraphicsConfigTemplate;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import app.pomoce.Kolor;

public class Kafelek {
	
	private BufferedImage kafelek;
	private Graphics2D g2d;
	private int rozmiar;
	private int szerokosc; 
	private int wysokosc;
	
	public Kafelek(int szerokosc, int wyskosc, int rozmiar) {
		this.szerokosc = szerokosc;
		this.wysokosc =  wyskosc;
		this.rozmiar = rozmiar;
		kafelek = new BufferedImage(
				szerokosc * rozmiar,
				wyskosc * rozmiar,
				BufferedImage.TYPE_INT_RGB);
		g2d = kafelek.createGraphics();
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON
				);
		rh.put(
				RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2d.addRenderingHints(rh);
		wyczysc();
	}

	private void wyczysc() {
		g2d.setColor(Kolor.get(0));
		g2d.fillRect(0, 0, szerokosc * rozmiar, wysokosc * rozmiar);	
	}

	public BufferedImage get() {
		return kafelek;
	}

	public void setPixel(int x, int y, int kolorTuszu) {
		g2d.setColor(Kolor.get(kolorTuszu));
		g2d.fillRect(
				x * rozmiar,
				y * rozmiar, 
				rozmiar,
				rozmiar
				);
		
	}
}
