package app.modele;

public class Drub {
	
	private int rodzaj;
	private int ilosc;
	
	public Drub() {
		ustaw(0, 0);
	}

	public Drub(int rodzaj, int ilosc) {
		ustaw(rodzaj, ilosc);
	}

	private void ustaw(int rodzaj, int ilosc) {
		this.rodzaj =  rodzaj;
		this.ilosc = ilosc;
	}

	public int getRodzaj() {
		return rodzaj;
	}

	public int getIlosc() {
		return ilosc;
	}
	
	public void updateIlos(int delta) {
		ilosc += delta;
	}
}
