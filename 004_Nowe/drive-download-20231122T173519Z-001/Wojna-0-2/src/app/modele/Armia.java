package app.modele;

public class Armia {
	private int liczbaJednostek;

	public Armia() {
		this.liczbaJednostek = 100; // Przykładowa początkowa liczba jednostek.
	}

	public int obliczMocAtaku() {
		// Tutaj możesz dodać logikę obliczania mocy ataku na podstawie liczby
		// jednostek.
		return liczbaJednostek;
	}

	public void zmniejszLiczbeJednostek(int ilosc) {
		this.liczbaJednostek -= ilosc;
		if (this.liczbaJednostek < 0) {
			this.liczbaJednostek = 0;
		}
	}

	public boolean czyMaJednostki() {
		return liczbaJednostek > 0;
	}
}
