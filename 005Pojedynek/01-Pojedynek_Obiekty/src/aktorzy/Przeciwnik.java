package aktorzy;

import java.awt.Color;
import java.awt.Graphics;

import mechanizmy.SzybkoStrzelnosc;

public class Przeciwnik extends Duszek {

	private PasekZycia pasekZyica;
	private SzybkoStrzelnosc szybkoStrzelnosc;
	
	public Przeciwnik(int x, int y, int szerokosc, int wysokosc, Color kolor, int ilosc) {
		super(x, y, szerokosc, wysokosc, kolor, ilosc);
		pasekZyica = new PasekZycia(x, y - 10);
		szybkoStrzelnosc = new SzybkoStrzelnosc(5);
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
}
