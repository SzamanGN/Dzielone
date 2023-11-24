package app.modele;

public class ObslugaKonta {

	private int stan;
	
	public ObslugaKonta() {
		stan = 1000;
	}
	
	public int getStan() {
		return stan;
	}
	
	public void wplata(int ile) {
		if(ile > 0) {
			stan += ile;
		}
	}
	
	public boolean wyplata(int ile) {
		boolean wynik = false;
		int tmp =  stan - ile;
		if (tmp >= 0) {
			stan = tmp;
			wynik = true;
		}
		return wynik;
	}
}
