package modele;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Duszek {
	
	private Image obrazek;

	protected Rectangle obszar;
	
	public Duszek(int x, int y, int szerkosc, int wysokosc) {
		obszar = new Rectangle(x, y, szerkosc, wysokosc);
	}
	
	public Rectangle getObszar() {
		return obszar;
	}
	
	protected void setObrazek(Image nowyObrazek) {
		obrazek = nowyObrazek;
	}
	
	public void draw(Graphics g) {
		g.drawImage(obrazek, obszar.x, obszar.y, null);
	}
}
