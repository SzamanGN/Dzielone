package gracze;

import modele.Armia;

public class Gracz {
	private String nazwa;
	private Armia armia;
	
	public Gracz(String nazwa) {
		this.nazwa = nazwa;
		this.armia =  new Armia();
	}

	public Gracz(String nazwa, Armia armia) {
		this.nazwa = nazwa;
		this.armia = armia;
	}

	public void atakuj(Gracz przeciwnik) {
		int mocAtaku = this.armia.obliczMocAtaku();
		przeciwnik.obrona(mocAtaku);
	}

	private void obrona(int mocAtakuPrzeciwnika) {
		// Tutaj możesz dodać logikę obrony, np. zmniejszenie liczby jednostek w armii
        // w zależności od mocy ataku przeciwnika
		
	}
	
	public boolean czyZyje() {
		return armia.czyMaJednostki();
	}

}
