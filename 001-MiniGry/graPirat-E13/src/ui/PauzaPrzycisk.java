package ui;

import java.awt.Rectangle;

public class PauzaPrzycisk {

	protected int x, y, szerkosc, wysokosc;
	protected Rectangle bounds;

	public PauzaPrzycisk(int x, int y, int szerkosc, int wysokosc) {
		this.x = x;
		this.y = y;
		this.szerkosc = szerkosc;
		this.wysokosc = wysokosc;
		
		createBounds();
	}

	private void createBounds() {
		bounds = new Rectangle(x , y, szerkosc, wysokosc);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSzerkosc() {
		return szerkosc;
	}

	public int getWysokosc() {
		return wysokosc;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	
}
