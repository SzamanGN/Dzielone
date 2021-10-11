package gra.dane;

public class Surowiec {

	private int nazwa;
	private int cena;
	
	public Surowiec() {
		ustaw(0, 0);
	}

	public Surowiec(int nazwa, int cena) {
		ustaw(nazwa, cena);
	}
	
	private void ustaw(int nazwa, int cena) {
		this.nazwa = nazwa;
		this.cena = cena;
	}

	public int getNazwa() {
		return nazwa;
	}

	public int getCena() {
		return cena;
	}
	
	public boolean aktualizacjaCeny(int delta) {
		boolean status = false;
		if (delta != 0) {
			if (delta < 0 && cena > 5) {
				cena -= 1;
				status = true;
			} else  if (delta > 0 && cena < 25) {
				cena += 1;
				status = true;
			}
		}
		return status;
	}
}
