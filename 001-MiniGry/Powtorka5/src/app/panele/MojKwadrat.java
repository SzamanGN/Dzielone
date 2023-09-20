package app.panele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class MojKwadrat {
	private  int x;
	private int y;
	private int dlugosc;
	private int wysokosc;
	private int xKierunek = 1;
	private int yKIerunek = 1;
	private Color kolor;
	private Random losowa;
	
	public MojKwadrat(int x, int y) {
		this.x = x;
		this.y = y;
		dlugosc = losowa.nextInt(50);
		wysokosc = dlugosc;
		kolor =  new Color(150, 20, 90);
	}
	
	public void aktulizacjaMojKwadrat() {
		this.x += xKierunek;
		this.y += yKIerunek;
		
		if((x + dlugosc) > 400 || x < 0) {
			xKierunek *= -1;
			kolor = nowyKolor();
		}
		if((y + wysokosc) > 400 || y < 0){
			yKIerunek *= -1;
			kolor = nowyKolor();
		}		
	}

	private Color nowyKolor() {
		return new Color(losowa.nextInt(255), losowa.nextInt(255), losowa.nextInt(255));
	}
	
	public void rysuj(Graphics g) {
		g.setColor(kolor);
		g.fillRect(x, y, wysokosc, dlugosc);
	}

}
