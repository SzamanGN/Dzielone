package modele;

import java.awt.Graphics;
import java.awt.Image;

public class Serce extends Duszek {
	
	public Serce() {
		super(0, 0, 0, 0);
	}


	public Serce(int x, int y, int szerkosc, int wysokosc) {
		super(x, y, szerkosc, wysokosc);
	}

	
	public Serce(int x) {
		super(x, -36, 41, 41);
	}
	
	public void draw(Graphics g, Image obrazekSerce ) {
		g.drawImage(obrazekSerce, obszar.x, obszar.y, null);
	}
	
	public void ruch() {
		obszar.y += 1;
	}

}
