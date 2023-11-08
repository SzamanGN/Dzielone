package kurnik;

import modele.Zwierze;

public class Kogut extends Zwierze{

	public Kogut() {
		super(0, 0, 0, 0, true, 0);
	}
	
	public Kogut(int czasZycia, int wiek) { 
		super(0, czasZycia, wiek, 20, true, 0); // dojrzalosc pobieram z globalnego statycznego paramtru dojrzalosc/zwierze
	}
}
