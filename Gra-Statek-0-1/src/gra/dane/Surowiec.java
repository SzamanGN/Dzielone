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
	
}
