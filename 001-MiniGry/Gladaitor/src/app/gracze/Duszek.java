package app.gracze;

import app.narzedzia.Generator;

public class Duszek {
	private String nazwa;
	private int punktyZycia;
	private int punktyAtaku;
	private int puktyObrony;
	
	public Duszek(String nazwa, int puntyZycia, int punktyAtaku, int puktyObrony)  {
		this.nazwa = nazwa;
		this.punktyZycia = puntyZycia;
		this.punktyAtaku = punktyAtaku;
		this.puktyObrony = puktyObrony;
	}
	
	public String toString() {
		return String.format(
				"Nazwa: %s, zyice: %d, atak: %d, obrona: %d",
				nazwa, punktyZycia, punktyAtaku, puktyObrony
				);
	}
	
	public int getWyliczonyAtak() {
		return punktyAtaku + Generator.getLosowa(punktyAtaku);
		// wartosc ataku = pukty ataku + losowa z (punty ataku -1)
 	}
	
	public int  getWyliczonaObrona() {
		return puktyObrony + Generator.getLosowa(puktyObrony);
	}
	
	public boolean otrzymaneObrazenia(int iloscObrazen) {
		punktyZycia  -= iloscObrazen;
		return (punktyZycia <= 0);
	}
}
