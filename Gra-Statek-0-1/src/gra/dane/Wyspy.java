package gra.dane;

import java.util.ArrayList;

import gra.narzedzia.Nazwy;

public class Wyspy {

	private ArrayList<Wyspa> wyspy;
	
	public Wyspy() {
		wyspy = new ArrayList<Wyspa>();
		generowanieWysp();
	}

	private void generowanieWysp() {
		for (int w = 0; w < Nazwy.iloscWysp(); w++) {
			wyspy.add(new Wyspa(w));
		}
	}
	
	public Wyspa get(int indeks) {
		return wyspy.get(indeks);
	}
}
