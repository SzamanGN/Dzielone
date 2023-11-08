package modele;

public class Zycie {
	private int czasZycia;
	private int wiek;
	private int dojrzalosc; // ilosc cykli okreslona
	
	public Zycie(int czasZycia, int wiek, int dojrzalosc) {
		this.czasZycia = czasZycia;
		this.wiek = wiek;
		this.dojrzalosc = dojrzalosc;
	}

	public boolean isZyje() {
		return wiek <= czasZycia;
	}
	
	public boolean isDojrzaly() {
		return wiek >= dojrzalosc;
	}
	
	public void tikZegara() {
		if (isZyje()) {
			wiek += 1;
		}
	}
}
