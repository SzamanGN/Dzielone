package kurnik;

import java.util.ArrayList;

import modele.Zwierze;

public class Kura extends Zwierze {

	private ArrayList<Boolean> jajka;
	
	public Kura() {
		super(1, 0, 0, 0, false, 0);
		ustawListeJaj();
	}
	
	public Kura(int id) {
		super(id, 0, 0, 0, false, 0);
		ustawListeJaj();
	}
	
	public Kura(int czasZycia, int wiek, int czasCiazy) {
		super(1, czasZycia, wiek, 20, false, czasCiazy ); // dojrzalosc pobieram z globalnego statycznego paramtru dojrzalosc/zwierze
		ustawListeJaj();
	}
	
	private void ustawListeJaj() {
		jajka = new ArrayList<Boolean>();
		for(int j = 0; j < 5; j++) {
			jajka.add(false);
		}
	}

	@Override
	public void tikZegara() {
		super.tikZegara();
		if (getCiaza().isMiot()) {
			int ilosc = jajka.size();
			for (int i = 0; i < ilosc; i++) {
				if(!jajka.get(i)) {
					jajka.set(i, true);
					break;
				}
			}
		}
	}
	
	public boolean isJajko(int ktore) {
		return jajka.get(ktore);
	}
	
	public void removJajko(int ktore) {
		jajka.set(ktore, false);
	}
}
