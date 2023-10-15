package modele;

public class Minutnik {
	
	private int minuty;
	private int sekundy;
	
	public Minutnik(int minuty, int sekundy) {
		this.minuty = minuty;
		this.sekundy = sekundy;
	}

	public String getCzas() {
		return String.format("%02d:%02d", minuty, sekundy);
	}
	
	public void tikZegara() {
		if ((minuty + sekundy) > 0) {
			sekundy -= 1;
			if (sekundy < 0 && minuty > 0) {
				minuty -= 1;
				sekundy = 59;
			}
		}
	}
	
	public boolean isAktyny() {
		return (minuty + sekundy) > 0;
	}
}
