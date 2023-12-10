package aktorzy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Duszek {

	protected Rectangle obszar;
	private Color kolor;
	protected int ilosc;
	
	public Duszek(int x, int y, int szerokosc, int wysokosc, Color kolor, int ilosc) {
		obszar = new Rectangle(x, y, szerokosc, wysokosc);
		this.kolor = kolor;
		this.ilosc = ilosc;
	}
	
	public void rysowanie(Graphics g) {	
		g.setColor(kolor);
		g.fillRect(
				obszar.x,
				obszar.y,
				obszar.width,
				obszar.height
				);
	}
}
