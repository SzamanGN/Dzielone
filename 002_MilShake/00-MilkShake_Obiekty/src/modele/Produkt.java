package modele;

import java.awt.Color;

public class Produkt {

	private int id;
	private int ilosc;
	private Color tlo, tusz;

	public Produkt() {
		ustaw(0, 0, null, null);
	}

	public Produkt(int id, int ilosc, Color tlo, Color tusz) {
		ustaw(id, ilosc, tlo, tusz);
	}

	private void ustaw(int id, int ilosc, Color tlo, Color tusz) {
		this.id = id;
		this.ilosc = ilosc;
		this.tlo = tlo;
		this.tusz = tusz;
	}

	public int getId() {
		return id;
	}

	public int getIlosc() {
		return ilosc;
	}

	public void updateIlosc(int delta) {
		ilosc += delta;
	}

	public Color getTlo() {
		return tlo;
	}

	public Color getTusz() {
		return tusz;
	}

	
}
