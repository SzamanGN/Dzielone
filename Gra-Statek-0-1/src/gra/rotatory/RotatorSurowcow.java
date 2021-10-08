package gra.rotatory;

import java.util.ArrayList;

import gra.narzedzia.GeneratorLiczb;
import gra.narzedzia.Nazwy;

public class RotatorSurowcow {

	private ArrayList<Integer> dostepne;
	
	public RotatorSurowcow() {
		dostepne = new ArrayList<Integer>();
		
		ladowanieDanych();
	}

	private void ladowanieDanych() {
		for (int s = 0; s < Nazwy.iloscSurowcow(); s++) {
			dostepne.add(s);
		}
	}
	
	public int pobierz() {
		int indeks = GeneratorLiczb.losowa(dostepne.size());
		int pobrana = dostepne.get(indeks);
		dostepne.remove(indeks);
		return pobrana;
	}

}
