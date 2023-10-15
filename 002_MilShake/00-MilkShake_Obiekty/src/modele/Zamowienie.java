package modele;

public class Zamowienie {
	
	private int id;
	private Minutnik minutnik;
	
	public Zamowienie() {
		ustaw(0, 0, 0);
	}
	
	public Zamowienie(int id) {
		ustaw(id, 0, 0);
	}
	
	public Zamowienie(int id, int minuty, int sekundy) {
		ustaw(id, minuty, sekundy);
	}

	private void ustaw(int id, int minuty, int skeundy) {
		this.id = id;
		minutnik = new Minutnik(minuty, skeundy);
	}
	
	public int getId() {
		return id;
	}
	
	public String getCzas() {
		return minutnik.getCzas();
	}
	
	public boolean isAktywne() {
		return minutnik.isAktyny();
	}
	
	public void tikZegara() {
		minutnik.tikZegara();
	}
}
