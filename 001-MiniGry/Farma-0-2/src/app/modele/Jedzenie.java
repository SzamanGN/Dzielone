package app.modele;

public class Jedzenie {
	
	private int rodzaj;
	private int ilosc;
	
	public Jedzenie() {
		ustaw(0, 0);
	}
	
	public Jedzenie(int rodzaj, int ilosc) {
		ustaw(rodzaj, ilosc);
	}

	private void ustaw(int rodzaj, int ilosc) {
		this.ilosc = ilosc;
		this.rodzaj = rodzaj;
	}

	public int getRodzaj() {
		return rodzaj;
	}

	public int getIlosc() {
		return ilosc;
	}

	
}
