package gra.dane;

public class Statek {

	private boolean plynie;
	private int wyspa;
	private int pojemnosc;
	private int iloscTowaru;
	private int nazwaTowaru;
	private int cenaTowaru;
	
	public Statek(int wyspa) {
		ustaw(false, wyspa, 10, 0, 0, 0);
	}
	
	public Statek(boolean plynie, int wyspa, int pojemnosc, int iloscTowaru, int nazwaTowaru, int cenaTowaru) {
		ustaw(plynie, wyspa, pojemnosc, iloscTowaru, nazwaTowaru, cenaTowaru);
	}

	private void ustaw(boolean plynie, int wyspa, int pojemnosc, int iloscTowaru, int nazwaTowaru, int cenaTowaru) {
		this.plynie = plynie;
		this.wyspa = wyspa;
		this.pojemnosc = pojemnosc;
		this.iloscTowaru = iloscTowaru;
		this.nazwaTowaru = nazwaTowaru;
		this.cenaTowaru = cenaTowaru;
	}

	public boolean isPlynie() {
		return plynie;
	}

	public int getWyspa() {
		return wyspa;
	}

	public int getPojemnosc() {
		return pojemnosc;
	}

	public boolean isTowar() {
		return (iloscTowaru > 0);
	}
	
	public int getIloscTowaru() {
		return iloscTowaru;
	}

	public int getNazwaTowaru() {
		return nazwaTowaru;
	}

	public int getCenaTowaru() {
		return cenaTowaru;
	}
	
	
}
