package aktorzy;

import java.awt.Color;
import java.awt.Graphics;

import mechanizmy.SzybkoStrzelnosc;

public class Gracz extends Duszek {
	
	private PasekZycia pasekZyica;
	private SzybkoStrzelnosc szybkoStrzelnosc;

	public Gracz(int x, int y, int szerokosc, int wysokosc, Color kolor, int ilosc) {
		super(x, y, szerokosc, wysokosc, kolor, ilosc);
		pasekZyica = new PasekZycia(x, y - 10);
		szybkoStrzelnosc = new SzybkoStrzelnosc(5); // co 5 cykli oddanie strzalu
	}

	@Override
	public void rysowanie(Graphics g) {
		super.rysowanie(g);
		pasekZyica.rysowanie(g);
	}

	public void aktualizacjaZycia(int delta) {
		pasekZyica.aktualizacjaZycia(delta);
	}
	
	public void tikZegara() {
		szybkoStrzelnosc.tikZegara();
	}

	public boolean isStrzela() {
		return szybkoStrzelnosc.isStrzal();
	}

	public Strzala strzal() {
		return new Strzala(
				obszar.x + obszar.width,
				obszar.y,
				obszar.height,
				ilosc,
				1
				);
	}
}
