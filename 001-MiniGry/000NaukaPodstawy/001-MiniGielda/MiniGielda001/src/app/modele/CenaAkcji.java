package app.modele;

public class CenaAkcji {
	
	private int cena;
	
	public CenaAkcji() {
		cena = 100;
	}

	public int getCena() {
		return cena;
	}
	
	public void aktualizacjaCeny(int delta) {
		int tmp = cena + delta;
		if(tmp > 75 && tmp < 125) {
			cena = tmp;
		}
	}
}
