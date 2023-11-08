package modele;

public class Armia {
	private int liczbaJednostek;
	
	public Armia() {
		ustaw(100);
	}

	public Armia(int liczbaJednostek) {
		ustaw(liczbaJednostek);
	}
	
	public void ustaw(int liczbaJednostek) {
		this.liczbaJednostek = liczbaJednostek;
	}
	
	public int obliczMocAtaku() {
		return liczbaJednostek;
	}
	
	public boolean czyMaJednostki() {
		return liczbaJednostek > 0;
	}

}
