package modele;

public class Produkt {

	private int id;
	private int ilosc;

	public Produkt() {
		ustaw(0, 0);
	}

	public Produkt(int id, int ilosc) {
		ustaw(id, ilosc);
	}

	private void ustaw(int id, int ilosc) {
		this.id = id;
		this.ilosc = ilosc;
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

}
