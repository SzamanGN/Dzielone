package app.gracze;

public class GraczA extends Duszek {
	
	public GraczA(String nazwa, int puntyZycia, int punktyAtaku, int puktyObrony) {
		super(nazwa, puntyZycia, punktyAtaku, puktyObrony);
		puntyZycia = 100;
		punktyAtaku = 15;
		puktyObrony = 20;
		ustawNazwe("GraczA");
		
	}

	private void ustawNazwe(String nazwa) {
		nazwa = nazwa;
		
	}

}
