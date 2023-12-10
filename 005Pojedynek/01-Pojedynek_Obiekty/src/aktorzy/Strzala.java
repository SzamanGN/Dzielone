package aktorzy;

import java.awt.Color;

public class Strzala extends Duszek{
	
	private int kierunek;
	
	public Strzala(int x, int y, int wysokosc, int ilosc, int kierunek) {
		super(x, y, 25, wysokosc, Color.YELLOW, ilosc);
		this.kierunek = kierunek;
	}
	
	public void tikZegara() {
		obszar.x += 50 * kierunek;	
	}
}
