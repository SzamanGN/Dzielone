package app.modele;

public class Terytorium {
	private String nazwa;
	private Gracz wlasciciel;

	public Terytorium(String nazwa) {
		this.nazwa = nazwa;
		wlasciciel = null; // Początkowo brak właściciela
	}

	public Gracz getWlasciciel() {
		return wlasciciel;
	}

	public void setWlasciciel(Gracz nowyWlasciciel) {
		wlasciciel = nowyWlasciciel;
	}
}
