package gra.dane;

import gra.narzedzia.GeneratorLiczb;
import gra.rotatory.RotatorSurowcow;

public class Wyspa {

	private int nazwa;
	private Surowiec[] surowceDoKupna;
	private Surowiec[] surowceDoSprzedazy;
	
	public Wyspa() {
		ustaw(0);
	}

	public Wyspa(int nazwa) {
		ustaw(nazwa);
	}
	
	private void ustaw(int nazwa) {
		this.nazwa = nazwa;
		surowceDoKupna = new Surowiec[3];
		surowceDoSprzedazy = new Surowiec[3];
		RotatorSurowcow rs = new RotatorSurowcow();
		for (int s = 0; s < 3; s++) {
			surowceDoKupna[s] = new Surowiec(rs.pobierz(), (5 + GeneratorLiczb.losowa(10)));
			surowceDoSprzedazy[s] = new Surowiec(rs.pobierz(), (5 + GeneratorLiczb.losowa(10)));
		}
	}
	
	public int getNazwa() {
		return nazwa;
	}
	
	public int getNazwaSurowcaDoKupna(int indeks) {
		return surowceDoKupna[indeks].getNazwa();
	}
	
	public int getCenaSurowcaDOKupna(int indeks) {
		return surowceDoKupna[indeks].getCena();
	}
	
	public int getNazwaSurowcaDoSprzedazy(int indeks) {
		return surowceDoSprzedazy[indeks].getNazwa();
	}
	
	public int getCenaSurowcaDoSprzedazy(int indeks) {
		return surowceDoSprzedazy[indeks].getCena();
	}
	
	public boolean aktualizacjaCenySurowcaDoKupna(int indeks, int delta) {
		return surowceDoKupna[indeks].aktualizacjaCeny(delta);
	}
	
	public boolean aktualizacjaCenySurowcaDoSprzedazy(int indeks, int delta) {
		return surowceDoSprzedazy[indeks].aktualizacjaCeny(delta);
	}
}
