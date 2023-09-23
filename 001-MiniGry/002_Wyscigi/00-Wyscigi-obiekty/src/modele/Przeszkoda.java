package modele;

import java.awt.Graphics;
import java.awt.Image;

public class Przeszkoda  extends Duszek{

	public Przeszkoda() {
		super(0, 0, 0, 0);
		
	}
	
	public Przeszkoda(int x) {
		super(x,
				-75,
				 80,
				 80);
		
	}
	
	public Przeszkoda(int x, int y, int szerkosc, int wysokosc) {
		super(x, y, szerkosc, wysokosc);
		
	}
	
	public void draw(Graphics g, Image obrazekPrzeszkody) {
		g.drawImage(obrazekPrzeszkody, obszar.x, obszar.y, null);
	}
	
	public void ruch() {
		obszar.y += 3;
	}

}
