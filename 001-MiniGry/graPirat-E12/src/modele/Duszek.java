package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public abstract class Duszek {

	protected float x;
	protected float y;
	protected int szerokosc;
	protected int wysokosc;
	protected Rectangle2D.Float detekcjaKolizji; 
	
	public Duszek(float x, float y, int szerokosc, int wysokosc) {
		this.x = x;
		this.y = y;
		this.szerokosc = szerokosc;
		this.wysokosc = wysokosc;		
	}
	
	protected void rysyujDetekcjeKolizji(Graphics g ) {
		// dla pokazania tylko kolizji
		g.setColor(Color.PINK);
		g.drawRect((int) detekcjaKolizji.x, (int) detekcjaKolizji.y, (int) detekcjaKolizji.width
				,(int) detekcjaKolizji.height);
	}
	
	protected void ladowanieKolizji(float x, float y, float szerokosc, float wysokosc) {
		detekcjaKolizji = new Rectangle2D.Float( x, y, szerokosc, wysokosc);
	}
	
//	protected void aktilizuj() {
//		detekcjaKolizji.x = (int) x;
//		detekcjaKolizji.y = (int) y;
//	}
	
	public Rectangle2D.Float getDetekcjaKolizji(){
		return detekcjaKolizji;
	}
}
